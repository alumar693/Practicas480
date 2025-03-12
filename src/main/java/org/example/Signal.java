package org.example;

public class Signal {
    private String message;
    //Porcentaje de señal efectiva.
    private Double signal;
    private final double MAX_SIGNAL_PCT = 100;

    public Signal(String message) {
        this.message = message;
        this.signal = MAX_SIGNAL_PCT;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getSignal() {
        return signal;
    }

    public void setSignal(Double signal) {
        this.signal = signal;
    }
}
