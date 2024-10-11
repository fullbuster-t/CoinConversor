package com.fullbuster.coinconversor.functions;

import java.util.Scanner;

public class Menu {
    String option;
    Scanner read = new Scanner(System.in);

    public void viewMenu (){
        System.out.println("*******************************************************\n");
        System.out.println("¡Bienvenido al sistema de conversión de Monedas!");
        System.out.println("A continuación elige una opción para convertir:\n");
        System.out.println("1) Peso mexicano =====> Dólar");
        System.out.println("2) Dólar =====> Peso mexicano");
        System.out.println("3) Peso argentino =====> Dólar");
        System.out.println("4) Dòlar =====> Peso argentino");
        System.out.println("5) Real brasileño =====> Dólar");
        System.out.println("6) Dólar =====> Real brasileño");
        System.out.println("7) Peso colombiano =====> Dólar");
        System.out.println("8) Dólar =====> Peso colombiano");
        System.out.println("9) Conmsultar el historial de conversiones");
        System.out.println("0) Salir");
        var option = Integer.valueOf(read.nextLine());
    }


}
