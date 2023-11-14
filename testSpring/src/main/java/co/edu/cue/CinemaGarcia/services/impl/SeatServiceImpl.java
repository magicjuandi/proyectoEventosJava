package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.SeatDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class SeatServiceImpl implements Service<SeatDto> {
    @Override
    public List<SeatDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public SeatDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(SeatDto seatDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
