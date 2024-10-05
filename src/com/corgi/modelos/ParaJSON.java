package com.corgi.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class ParaJSON {
    public void guardarJson(ModeloMoneda moneda, double montoConvertido) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nombreArchivo = moneda.base_code() + "a" + moneda.target_code() + ".json";

        // Convertir el objeto MonedaOmdb a JsonObject
        JsonObject jsonMoneda = gson.toJsonTree(moneda).getAsJsonObject();

        // Agregar el nuevo campo monto_convertido
        jsonMoneda.addProperty("monto_convertido", montoConvertido);

        try (FileWriter escritura = new FileWriter(nombreArchivo)) {
            // Escribir el objeto JSON al archivo
            escritura.write(gson.toJson(jsonMoneda));
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
            throw e;
        }
    }
}
