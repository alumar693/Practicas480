package org.example;

public class Transmitter implements ISwitchableDevice, ISignalProcessor {
    private boolean active;
    private Signal signal;
    private final boolean DEFAULT_STATE = false;

    public Transmitter(Signal message) {
        this.active = DEFAULT_STATE;
        this.signal = message;
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
    public Signal processSignal(Signal signal) {
        this.signal.setMessage(MorseCodeTranslator.text2Morse(signal.getMessage()));
        return signal;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Signal getSignal() {
        return signal;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }
}
