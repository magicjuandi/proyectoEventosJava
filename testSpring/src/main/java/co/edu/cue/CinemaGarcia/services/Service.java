package co.edu.cue.CinemaGarcia.services;

import java.util.List;

public interface Service<T> {
    List<T> list();

    T byId(Long id);

    void save(T t);

    void delete(Long id);

}
