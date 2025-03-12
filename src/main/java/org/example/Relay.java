package org.example;

public class Relay implements ISignalProcessor {
    //True = encendido; False = apagado;
    private boolean state;
    private final boolean DEFAULT_STATE = true;
    private final double MAX_SIGNAL_PCT = 100;

    public Relay() {
        this.state = DEFAULT_STATE;
    }
    @Override
    public Signal processSignal(Signal signal) {
        signal.setSignal(MAX_SIGNAL_PCT);
        return signal;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
