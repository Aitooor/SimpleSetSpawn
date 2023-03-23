package online.starsmc.simplesetspawn.service;

public interface Service {

    void start();

    default void stop() {
    }
}
