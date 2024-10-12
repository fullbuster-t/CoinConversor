package com.fullbuster.coinconversor.functions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileGenerator {

    public static void generateTXT(List<String> historial) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("historial_conversiones.txt"))) {
            for (String conversion : historial) {
                writer.write(conversion.toString());
                writer.newLine();
            }
            System.out.println("\nHistorial de conversiones guardado");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar el historial: " + e.getMessage());
        }
    }

    public static void readHistorial() {
        try {
            Files.lines(Paths.get("Historial_conversiones.txt")).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el historial: " + e.getMessage());
        }
    }
}
