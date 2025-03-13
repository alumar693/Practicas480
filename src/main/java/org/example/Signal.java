package org.example;

enum SignalStatus {
    ACTIVE, //La señal está bien y se puede seguir transmitiendo.
    WEAK, //La señal ha bajado por debajo del umbral y debe ser amplificada
    LOST //La señal se ha perdido
}

public class Signal {
    private String message;
    //Porcentaje de señal efectiva.
    private Double signalStrength;
    private SignalStatus status;
    private final double MAX_SIGNAL_PCT = 100;

    public Signal(String message) {
        this.message = message;
        this.signalStrength = MAX_SIGNAL_PCT;
        this.status = SignalStatus.ACTIVE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(Double signalStrength) {
        this.signalStrength = signalStrength;
    }

    public SignalStatus getStatus() {
        return status;
    }

    public void setStatus(SignalStatus status) {
        this.status = status;
    }

    public double getMAX_SIGNAL_PCT() {
        return MAX_SIGNAL_PCT;
    }
}
