package org.example;

public class Transmitter implements IMessageProcessorDevice {
    private boolean active;
    private Signal message;
    private final boolean DEFAULT_STATE = false;

    public Transmitter(Signal message) {
        this.active = DEFAULT_STATE;
        this.message = message;
    }

    @Override
    public void activate() {
        this.active = true;
        System.out.println("Emisor activado");
    }

    @Override
    public void deactivate() {
        this.active = false;
        System.out.println("Emisor desactivado");
    }

    @Override
    public void processMessage(Signal signal) {
        this.message.setMessage(MorseCodeTranslator.text2Morse(signal.getMessage()));
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Signal getMessage() {
        return message;
    }

    public void setMessage(Signal message) {
        this.message = message;
    }
}
