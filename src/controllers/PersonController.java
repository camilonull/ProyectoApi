package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import models.Person;

public class PersonController {
	
    private final String endpoint;

    public PersonController() {
        this.endpoint = "https://619c436c68ebaa001753c7fa.mockapi.io/persons";
    }

    public String getPersons() {
    	String json = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
            System.out.println(json);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return json;
    }
    
    public String getPersonId(int id) {
    	String json = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint+"/"+id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .GET()
                .build();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return json;
    }
    
    public String createPerson(String body) {
    	String json = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void updatePerson(String body, int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String deletePerson(int id) {
    	String json = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint + "/" + id))
                .headers("Content-Type", "application/json")
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .DELETE()
                .build();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body();
            if(json != "Not found") {
            	json = "Borrado con exito";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return json;
    }
    
    public String personToJson(Person person) {
        Gson gson = new Gson();
        return gson.toJson(person);
    }
    
    public Person jsonToPerson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }
    
    public void getArray(String json) {
    	
    }
}
