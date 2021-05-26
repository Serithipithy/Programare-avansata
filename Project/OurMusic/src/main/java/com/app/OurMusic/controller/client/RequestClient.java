package com.app.OurMusic.controller.client;


import com.app.OurMusic.model.SongsEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestClient {
    HttpClient client = HttpClient.newHttpClient();
    static RestTemplate restTemplate = new RestTemplate();

    private static final String GET_TOP_SONGS = "http://localhost:8080/songs/top";
    private static final String POST_SONGS = "http://localhost:8080/songs/insert";
    private static final String UPDATE_VOTE_SONGS = "http://localhost:8080/songs/vote/{id}";

    public List<SongsEntity> getTopSongs() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(GET_TOP_SONGS))
                .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        List<SongsEntity> songs = mapper.readValue(response.body(), new TypeReference<List<SongsEntity>>() {
        });

        songs.forEach(System.out::println);
        return songs;
    }

    public int postSongs(String singer, String title, String link) throws IOException, InterruptedException {
        String json = new StringBuilder()
                .append("{")
                .append("\"singer\":\"")
                .append(singer)
                .append("\",")
                .append("\"title\":\"")
                .append(title)
                .append("\",")
                .append("\"link\":\"")
                .append(link)
                .append("\"")
                .append("}").toString();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create(POST_SONGS))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // print status code
        System.out.println(response.statusCode());
        return response.statusCode();
    }

    public void voteSong(int id) {
        Map<String, Integer> param = new HashMap<>();
        param.put("id", id);

        restTemplate.getForObject(UPDATE_VOTE_SONGS, String.class, param);
    }
}
