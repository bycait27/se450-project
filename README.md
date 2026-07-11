# SE 450 Project

## Sprint 1 Checklist

- **Are you in a group?** No  
- **If so, who else is in your group?** N/A
- **Do you have your GitHub account set up?** Yes
- **Do you have a public repository for your project?** Yes
- **What is the link to your GitHub repository?** [se450-project](https://github.com/bycait27/se450-project.git)
- **If you are in a group, does everyone have write access to the GitHub repo?** N/A
- **Do you have a "Hello World" program that compiles and runs?** Yes
- **Where is the entry point to your project?** `src/main/java/com/caitlinash/poketrainermanager/App.java`

## Sprint 2 (Project Idea)

I will be building my own Bill's PC as a terminal application. It is basically a storage system for Pokémon trainers to organize their Pokémon. The user should be able to view their boxes, deposit and withdraw Pokémon, search, sort, and view their Pokémon, as well as save and load their progress so that they can come back and see their boxes. 

In addition to JUnit5, I plan on using the Jackson Core and Lanterna libraries through Maven. Jackson will allow me to convert the PokéAPI JSON data into Java objects for me to utilize in my app. Lanterna is for making the terminal app UI a little more polished and easier to navigate. I will also be using the `java.net.http.HttpClient` to send requests to the PokéAPI.

## Features

...

## Technology

- Java
- Maven
- JUnit

## How to Run

**Clone the repository:**

```bash
git clone git@github.com:bycait27/se450-project.git
```

**Navigate to the project directory:**

```bash
cd se450-project
```

**Package, compile, and run with Maven:**

```bash
mvn clean package
mvn clean compile
mvn exec:java -Dexec.mainClass="com.caitlinash.poketrainermanager.App"
```

## How to Test

...

## License 

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  

see LICENSE file for more details