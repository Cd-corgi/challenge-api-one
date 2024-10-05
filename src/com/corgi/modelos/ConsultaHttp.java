package com.corgi.modelos;

import com.google.gson.*;

import java.net.*;
import java.net.http.*;

public class ConsultaHttp {
    public ModeloMoneda convetirMoneda(String MonedaLocal, String MonedaFinal, double Monto) {
        URI enlace = URI.create("https://v6.exchangerate-api.com/v6/f0018974ea306f0d56c66727/pair/" +
                MonedaLocal +
                "/" + MonedaFinal +
                "/" + Monto);

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest req = HttpRequest.newBuilder().uri(enlace).build();

     try {
        HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());
        return new GsonBuilder().setPrettyPrinting().create().fromJson(response.body(), ModeloMoneda.class);
     } catch (Exception e) {
         throw new RuntimeException("No se encontró la moneda");
     }
    }
}
