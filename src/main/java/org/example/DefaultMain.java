package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefaultMain {
    private static Scanner in = new Scanner(System.in);

    public static void run() {
        System.out.println("Esto es un simulador de un telégrafo eléctrico!");
        String message = "";
        while (message.isEmpty()) {
            System.out.println("Introduce el mensaje que quieres codificar: ");
            message = in.nextLine();
            if (message.isEmpty()) {
                System.out.println("El mensaje no puede estar vacío.");
            }
        }
        Transmitter transmitter = new Transmitter(new Signal(message));
        List<Cable> cables = new ArrayList<>();
        cables.add(new Cable(50, 10));
        cables.add(new Cable(10, 5));
        List<Relay> relays = new ArrayList<>();
        relays.add(new Relay());
        Receiver receiver = new Receiver();
        TelegraphSystem telegraphSystem = new TelegraphSystem(transmitter, cables, relays, receiver);
        telegraphSystem.run();
    }

    public static void main(String[] args) {
        run();
    }
}
