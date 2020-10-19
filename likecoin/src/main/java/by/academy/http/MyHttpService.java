package by.academy.http;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class MyHttpService {


    public void httpCreateTransaction(String senderWalletId, String recipientWalletId, int amount, String secretKey) {
        String url = "http://localhost:8084/create_transaction/"
                + senderWalletId + "/"
                + recipientWalletId + "/"
                + amount + "/"
                + secretKey;
        httpPost(url);
    }


    public void httpStartMining(String walletId, int duration) {
        String url = "http://localhost:8084/start_mining/" + walletId + "/" + duration;
        httpPost(url);
    }


    public void httpInitiate() {
        String url = "http://localhost:8084/init";
        httpPost(url);
    }


    public void httpPost(String url) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(url))
                .header("Content-Type", "application/json")
                .build();
        try {
            httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.notify();
        }
    }

    public void httpGet() {
    }
}
