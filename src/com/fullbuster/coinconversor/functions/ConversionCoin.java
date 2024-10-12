package com.fullbuster.coinconversor.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversionCoin {
    QueryCoin queryCoin = new QueryCoin();
    private static List<String> historial = new ArrayList<>();

    public void executeConversion (String badgeOrigin, String badgeDestiny, double amount) {

        try {
            double convertedAmount = queryCoin.convert(badgeOrigin, badgeDestiny, amount);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDate = now.format(formatter);

            String conversion = String.format("""
                    ------------------------------------------------
                    Fecha y hora de conversión: %s
                    Divisa de origen: %s
                    Divisa de destino: %s
                    Monto para convertir: %.2f
                    Resultado de la conversión: %.2f
                    %.2f %s equivale a %.2f %s
                    ------------------------------------------------
                    """.formatted(formattedDate, badgeOrigin, badgeDestiny, amount, convertedAmount, amount, badgeOrigin, convertedAmount, badgeDestiny));
            System.out.println(conversion);

            historial.add(conversion);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la conversión, intenta nuevamente. " );
        }

    }

    public static List<String> getHistorial() {
        return historial;
    }

}
