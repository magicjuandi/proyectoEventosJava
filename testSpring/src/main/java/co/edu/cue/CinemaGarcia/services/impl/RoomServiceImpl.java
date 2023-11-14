package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.RoomDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class RoomServiceImpl implements Service<RoomDto> {
    @Override
    public List<RoomDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public RoomDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(RoomDto roomDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
