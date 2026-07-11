package com.caitlinash.poketrainermanager;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

/* 
* Experimenting with libraries and PokéAPI
*/

public class App {
	public static void main(String[] args) throws Exception {
		// System.out.println("Hello World");

		// call the PokéAPI through the HttpClient 
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://pokeapi.co/api/v2/pokemon/piplup"))
			.header("Accept", "application/json")
			.GET() 
			.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		// Use Jackson to read the name, id, and height of the Pokémon
		ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(response.body());

		// practice with Lanterna when displaying the name, id, and height of the Pokémon
		DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
		Terminal terminal = terminalFactory.createTerminal();

        try (Screen screen = new TerminalScreen(terminal)) {
            screen.startScreen();
            screen.clear();
            screen.newTextGraphics().putString(2, 2, "BILL'S PC");
            screen.newTextGraphics().putString(2, 4,
                "Name: " + root.get("name").asText());
            screen.newTextGraphics().putString(2, 5,
                "ID: " + root.get("id").asInt());
            screen.newTextGraphics().putString(2, 6,
                "Height: " + root.get("height").asInt());
            screen.refresh();
            Thread.sleep(5000); // keep screen open for 5 seconds (since there is no input yet)
            screen.stopScreen();
        }
		
		// System.out.println(root.get("name").asText());
        // System.out.println(root.get("id").asInt());
        // System.out.println(root.get("height").asInt());
	}
}
