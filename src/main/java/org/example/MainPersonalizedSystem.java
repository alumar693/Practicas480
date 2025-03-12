package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPersonalizedSystem {
    private static Scanner in = new Scanner(System.in);

    public static void run() {
        List<Cable> cables = new ArrayList<>();
        List<Relay> relays = new ArrayList<>();
        int numOfCables = getPositiveInt("Cuántos cables quieres tener?");

        for (int i = 0; i < numOfCables; i++) {
            double length = getPositiveDouble("Cuál será la longitud del cable nº " + (i + 1) + "?");
            double signalLossPerKm = getPositiveDouble("Cuál será el porcentaje de pérdida de señal por kilómetro del cable nº " + (i + 1) + "?");
            cables.add(new Cable(length, signalLossPerKm));
        }

        int numOfRelays = getNonNegativeInt("Cuántos repetidores quieres tener en tu sistema?");
        for (int i = 0; i < numOfRelays; i++) {
            relays.add(new Relay());
        }

        String message = getNonEmptyString("Escribe aquí el mensaje: ");
        Transmitter transmitter = new Transmitter(new Signal(message));
        TelegraphSystem telegraphSystem = new TelegraphSystem(transmitter, cables, relays, new Receiver());
        telegraphSystem.run();
    }

    private static int getPositiveInt(String message) {
        int number;
        while (true) {
            System.out.println(message);
            try {
                number = in.nextInt();
                if (number > 0) {
                    in.nextLine();
                    return number;
                }
                System.out.println("Error: Debe ser un número mayor que 0.");
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                in.nextLine();
            }
        }
    }

    private static int getNonNegativeInt(String message) {
        int number;
        while (true) {
            System.out.println(message);
            try {
                number = in.nextInt();
                if (number >= 0) {
                    in.nextLine();
                    return number;
                }
                System.out.println("Error: No puede ser un número negativo.");
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                in.nextLine();
            }
        }
    }

    private static double getPositiveDouble(String message) {
        double number;
        while (true) {
            System.out.println(message);
            try {
                number = in.nextDouble();
                if (number > 0) {
                    in.nextLine();
                    return number;
                }
                System.out.println("Error: Debe ser un número mayor que 0.");
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                in.nextLine();
            }
        }
    }

    private static String getNonEmptyString(String message) {
        String input;
        while (true) {
            System.out.println(message);
            input = in.nextLine();
            if (!input.trim().isEmpty()) {
                return input;
            }
            System.out.println("Error: El mensaje no puede estar vacío.");
        }
    }


    public static void main(String[] args) {
        run();
    }
}
