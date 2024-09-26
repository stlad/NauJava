package ru.vaganov.naumen.task4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 {
    public String[] getAcceptHeaders() {
        var client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(buildRequest(), HttpResponse.BodyHandlers.ofString());
            return processResponse(response);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ошибка при отправке запроса");
            return new String[]{};
        }
    }

    private HttpRequest buildRequest() {
        return HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/anything"))
                .headers("Accept", "application/json;text/html")
                .GET()
                .build();
    }

    private String[] processResponse(HttpResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(response.body().toString()).findValue("headers");
            String acceptHeader = node.get("Accept").toString();

            return acceptHeader == null ?
                    new String[]{} :
                    acceptHeader.replace("\"", "").split(";");
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось десериализовать ответ");
            return new String[]{};
        }
    }

    public String getTask() {
        return "Вывести только допустимые типы ответа (поле “Accept”) из заголовков " +
                "(запрос выполняется по адресу “https://httpbin.org/anything”).";
    }
}
