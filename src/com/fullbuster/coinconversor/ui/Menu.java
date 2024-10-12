package com.fullbuster.coinconversor.ui;

import com.fullbuster.coinconversor.functions.ConversionCoin;
import com.fullbuster.coinconversor.functions.FileGenerator;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final ConversionCoin conversionCoin = new ConversionCoin();

    public void showMainMenu() {
        while (true) {
            System.out.println("**************************************************************\n");
            System.out.println("¡Bienvenido al sistema de conversión de Monedas!");
            System.out.println("Selecciona una opción");
            System.out.println("1) Convertir divisa");
            System.out.println("2) Ver historial");
            System.out.println("0) Salir");
            var option = Integer.valueOf(scanner.nextLine());

            if (option == 0) {
                System.out.println("\n¡Gracias por usar el conversor de monedas!");
                System.out.println("**************************************************************\n");
                break;
            }

            if (option == 1) {
                callConversion();
            } else if (option == 2) {
                viewHistorial();
            }
        }
    }

    private void callConversion() {
        viewCoinsMenu("origen");
        var badgeOrigin = scanner.nextLine();
        viewCoinsMenu("destino");
        var badgeDestiny = scanner.nextLine();
        System.out.println("\nIngresa la cantidad que deseas convertir:");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
            return;
        }

        conversionCoin.executeConversion(badgeOrigin, badgeDestiny, amount);
    }

    private void viewHistorial() {
        List<String> historial = ConversionCoin.getHistorial();
        if (!historial.isEmpty()) {
            FileGenerator.generateTXT(historial);
            FileGenerator.readHistorial();
        } else {
            System.out.println("No hay conversiones en el historial.");
        }
    }

    public static void viewCoinsMenu(String divisaDescription) {
        System.out.println("Ingresa la divisa de " + divisaDescription);
        System.out.println("""
                MXN - Peso mexicano             VES - Bolívar venezolano            SGD - Dólar de singapur
                USD - Dólar estadounidense      GTQ - Quetzal guatemalteco          INR - Rupia india
                EUR - Euro                      ZAR - Rand sudafricano              JMD - Dólar jamaicano
                JPY - Yen japonés               ARS - Peso argentino                NOK - Corona noruega
                CHF - Franco suizo              KRW - Won surcoreano                NIO - Córdoba nicaraguense
                CAD - Dólar canadiense          HKD - Dólar de Hong Kong            SEK - Corona sueca
                AUD - Dólar australiano         NZD - Dólar de Nueva Zelanda        CZK - Corno checa
                CNY - Yuan chino                CLP - Peso chileno                  RUB - Rublo ruso
                """);
    }
}
