package com.fullbuster.coinconversor.functions;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.fullbuster.coinconversor.modules.Coin;
import com.google.gson.Gson;

public class QueryCoin {

    public double convert(String coinOrigin, String coinDestiny, double amount) {
        URI url_str = URI.create("https://v6.exchangerate-api.com/v6/a52d86166ea277149728e8d5/latest/" + coinOrigin);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url_str)
                .build();

        try {
            HttpResponse<String> response = client.
                    send(request, HttpResponse.BodyHandlers.ofString());

            Coin coin = new Gson().fromJson(response.body(), Coin.class);

            Map<String, Double> conversionRates = coin.conversion_rates();
            double conversionRate = conversionRates.get(coinDestiny);

            return amount * conversionRate;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
