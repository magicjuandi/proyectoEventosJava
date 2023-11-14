package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.ReservationDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class ReservationServiceImpl implements Service<ReservationDto> {
    @Override
    public List<ReservationDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public ReservationDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(ReservationDto reservationDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
