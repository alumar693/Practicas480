package org.example;

import java.util.Random;

public class Cable implements ISignalProcessor{
    private Random random = new Random();
    private double length;
    private double signalLossPerKm;
    private final double MIN_SIGNAL_PCT = 10;

    public Cable(double length, double signalLossPerKm) {
        this.length = length;
        this.signalLossPerKm = signalLossPerKm;
    }
    @Override
    //Devuelve la señal que tiene cuando recorre todos los kilómetros del cable o la señal a la que se queda cuando baja del umbral de señal mínima;
    public Signal processSignal (Signal signal) {
        for (int i = 0; i < length; i++) {
            //Comprobar que sea divisible entre 10 para que solo sea true cada 10 km
            if ((i+1)%10 == 0) {
                //5% de probabilidad de que falle el cable y se pierda la señal
                int randomNumber = random.nextInt(100);
                System.out.println(randomNumber);
                if (randomNumber < 5) {
                    System.out.println("El cable ha fallado y la señal se ha perdido.");
                    signal.setSignal(null);
                    return signal;
                }
            }
            signal.setSignal(signal.getSignal() - signalLossPerKm);
            if (signal.getSignal() <= MIN_SIGNAL_PCT) {
                return signal;
            }
        }
        return signal;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSignalLossPerKm() {
        return signalLossPerKm;
    }

    public void setSignalLossPerKm(double signalLossPerKm) {
        this.signalLossPerKm = signalLossPerKm;
    }

    public double getMIN_SIGNAL_PCT() {
        return MIN_SIGNAL_PCT;
    }
}
