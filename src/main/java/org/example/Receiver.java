package org.example;

public class Receiver implements IMessageProcessorDevice {
    private boolean active;
    private String receivedMessage;
    private final boolean DEFAULT_STATE = false;

    public Receiver() {
        this.active = DEFAULT_STATE;
        this.receivedMessage = "";
    }

    @Override
    public void activate() {
        this.active = true;
        System.out.println("Receptor activado");
    }

    @Override
    public void deactivate() {
        this.active = false;
        System.out.println("Receptor desactivado");
    }

    @Override
    public void processMessage(Signal signal) {
        this.receivedMessage = MorseCodeTranslator.morse2Text(signal.getMessage());
    }

    public void display_message() {
        System.out.println("Tu mensaje descifrado es: " + receivedMessage);
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }

    public void setReceivedMessage(String receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDEFAULT_STATE() {
        return DEFAULT_STATE;
    }
}
