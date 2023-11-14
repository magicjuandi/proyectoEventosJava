package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.ScheduleDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class ScheduleServiceImpl implements Service<ScheduleDto> {
    @Override
    public List<ScheduleDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public ScheduleDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(ScheduleDto scheduleDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
