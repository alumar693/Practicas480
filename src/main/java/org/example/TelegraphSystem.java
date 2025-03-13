package org.example;

import java.util.List;

public class TelegraphSystem {
    private Transmitter transmitter;
    private List<Cable> cables;
    private List<Relay> relays;
    private Receiver receiver;

    public TelegraphSystem(Transmitter transmitter, List<Cable> cables, List<Relay> relays, Receiver receiver) {
        this.transmitter = transmitter;
        this.cables = cables;
        this.relays = relays;
        this.receiver = receiver;
    }

    public void run() {
        processMessage();

        // Transmitir la señal a través de cables y repetidores en la estructura cable - relay - cable
        Signal remainingSignal = transmitSignalThroughCablesAndRelays();
        if (remainingSignal.getStatus() != SignalStatus.LOST) {
            // Recibir y mostrar el mensaje, si la señal es válida
            receiveAndDisplayMessage(remainingSignal);
        }
    }

    private void processMessage() {
        if (!transmitter.isActive()) {
            transmitter.activate();
        }
        transmitter.processSignal(transmitter.getSignal());
        System.out.println("Tu mensaje cifrado es: " + transmitter.getSignal().getMessage());
        transmitter.deactivate();
    }

    private Signal transmitSignalThroughCablesAndRelays() {
        Signal remainingSignal = transmitter.getSignal();
        for (int i = 0; i < cables.size(); i++) {
            // Transmitir por el cable;
            remainingSignal = cables.get(i).processSignal(remainingSignal);
            //Si se ha roto el cable acabar la transmisión;
            if (remainingSignal.getStatus() == SignalStatus.LOST) {
                break;
            } else {
                transmitter.setSignal(remainingSignal);

                // Si hay un relay, amplificar la señal;
                if (remainingSignal.getStatus() == SignalStatus.WEAK) {
                    if (!relays.isEmpty()) {
                        for (Relay relay : relays) {
                                remainingSignal = relay.processSignal(remainingSignal);
                                transmitter.setSignal(remainingSignal);
                                break;
                        }
                    }
                }

                // Si la señal cae por debajo del umbral mínimo y no hay más cables, terminar;
                if (remainingSignal.getStatus() == SignalStatus.WEAK && i + 1 < cables.size()) {
                    remainingSignal.setSignalStrength(0.0);
                    transmitter.setSignal(remainingSignal);
                    break;
                }
            }
        }

        return remainingSignal;
    }

    private void receiveAndDisplayMessage(Signal remainingSignal) {
        if (remainingSignal.getStatus() == SignalStatus.ACTIVE) {
            if (!receiver.isActive()) {
                receiver.activate();
            }
            receiver.processSignal(remainingSignal);
            receiver.display_message();
            receiver.deactivate();
        } else {
            System.out.println("Te has quedado sin señal!");
        }
    }

    public Transmitter getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(Transmitter transmitter) {
        this.transmitter = transmitter;
    }

    public List<Cable> getCables() {
        return cables;
    }

    public void setCables(List<Cable> cables) {
        this.cables = cables;
    }

    public List<Relay> getRelays() {
        return relays;
    }

    public void setRelays(List<Relay> relays) {
        this.relays = relays;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}

