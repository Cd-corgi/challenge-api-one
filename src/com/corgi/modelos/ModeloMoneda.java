package com.corgi.modelos;

public record ModeloMoneda(String base_code,
                           String target_code,
                           double conversion_rate,
                           double conversion_result) {
}
