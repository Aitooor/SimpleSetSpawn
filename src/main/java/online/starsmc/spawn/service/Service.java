package online.starsmc.spawn.service;

public interface Service {

    void start();

    default void stop() {
    }
}
