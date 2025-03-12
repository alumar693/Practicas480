package org.example;

public interface IMessageProcessorDevice {
    void activate();
    void deactivate();
    void processMessage(Signal signal);
}
