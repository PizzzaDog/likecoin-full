package by.academy.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    public static HttpResponse<String> checkingHttpPost() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8084/check"))
                //.POST(HttpRequest.BodyPublishers.ofString("http://localhost:8084/likecoin-mining-service/checkingpojo"))
                .POST(HttpRequest.BodyPublishers.ofString(createPostBody()))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.statusCode());
    System.out.println(response.body());
        return response;
    }

      public static void main(String[] args) throws IOException, InterruptedException {
            checkingHttpPost();
      }

            private static String createPostBody() {
                return "{\"name\":\"checkhttp\"}";
            }
}
