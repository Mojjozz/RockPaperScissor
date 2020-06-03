# Cygni Home Test: Rock Paper Scissor
A simple HTTP-API that friends can use to solve disagreements. 
The project is based on a Spring boot application

### Thecnology used
* Java 14: programming language
* Spring boot: web application
* Maven: Building project

Startup guide
=
<b>Prerequisite</b>
  * Maven 
  * Java X or higher
  * Postman
  


<b>Installation guide</b>
* Unzip the file 
* Using the command terminal, go to the extracted folder, e.g C:\Users\..\rps
* To build the application type: mvn clean package, this create an JAR file in the C:\Users\..\rps\target folder

<b>Starting the application</b>
* To run the application type: java -jar target/gametest-0.0.1-SNAPSHOT.jar
* An alternativ way of running the application is to type: mvnw spring-boot:run
* The application runs on http://localhost:8080/api/...

###Endpoints
* POST /api/games  -> Creates a new game with a Game ID 
* POST /api/games/{id}/join -> Join game with specified Game ID 
*  POST /api/games/{id}/move -> Make a move
*  GET /api/games/{id}  -> check Status of game with the specified Game ID

Playing the game
=
###Keynotes
* All the POST request should contain a body with the specified keys, make sure the request body is in JSON format.
* The {Id} should be replaced with the specific GameID generated when creating a game.

<b>Creating a game</b>
* Using Postman, send a POST request to http://localhost:8080/api/games
* Include {"name":"whatever your name is"} in the body of the request
* Send the GameID located in the responsebody to the other player

<b>Joining a game</b>
* Send a POST request to http://localhost:8080/api/games/{Id}/join
* Include {"name":"whatever your name is"} in the body of the request

<b>Making a move</b>
* Send a POST request to http://localhost:8080/api/games/{Id}/move
* Include {"name":"whatever your name is", "move":"rock/paper/scissor"} in the body of the request

<b>Checking the status of a Game</b>
* Send a GET request to http://localhost:8080/api/games/{Id}


