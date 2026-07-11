package com.caitlinash.poketrainermanager;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

		System.out.println(root.get("name").asText());
		System.out.println(root.get("id").asInt());
		System.out.println(root.get("height").asInt());
	}
}
