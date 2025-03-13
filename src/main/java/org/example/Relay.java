package org.example;

public class Relay implements ISignalProcessor, ISwitchableDevice {
    //True = encendido; False = apagado;
    private boolean active;
    private int battery;
    private final boolean DEFAULT_STATE = false;
    private final double MAX_SIGNAL_PCT = 100;

    public Relay(int battery) {
        this.active = DEFAULT_STATE;
        this.battery = battery;
    }
    @Override
    public Signal processSignal(Signal signal) {
        System.out.println("La señal es débil, activando repetidor.");
        if (!isActive()) {
            activate();
        }
        System.out.println("Al repetidor le queda " + battery + " de batería.");
        if (battery <= 0) {
            System.out.println("La batería está agotada, carga el repetidor.");
            return signal;
        }
        signal.setSignalStrength(MAX_SIGNAL_PCT);
        signal.setStatus(SignalStatus.ACTIVE);
        battery--;
        System.out.println("La amplificación de la señal ha sido exitosa!");
        deactivate();
        return signal;
    }

    @Override
    public void activate() {
        this.active = true;
        System.out.println("Repetidor activado");
    }

    @Override
    public void deactivate() {
        this.active = false;
        System.out.println("Repetidor desactivado");
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public boolean isDEFAULT_STATE() {
        return DEFAULT_STATE;
    }

    public double getMAX_SIGNAL_PCT() {
        return MAX_SIGNAL_PCT;
    }
}
