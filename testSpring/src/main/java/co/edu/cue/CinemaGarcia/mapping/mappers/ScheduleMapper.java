package co.edu.cue.CinemaGarcia.mapping.mappers;

import co.edu.cue.CinemaGarcia.domain.entities.Schedule;
import co.edu.cue.CinemaGarcia.mapping.dtos.ScheduleDto;

import java.util.List;
import java.util.stream.Collectors;

public class ScheduleMapper {
    public static ScheduleDto mapFrom(Schedule source){
        return new ScheduleDto(source.getId(),
                source.getName(),
                source.getStartTime(),
                source.getEndTime());
    }
    public static Schedule mapFrom(ScheduleDto source){
        return new Schedule(source.id(),
                source.name(),
                source.startTime(),
                source.endTime());
    }
    public static List<ScheduleDto> mapFrom(List<Schedule> source) {
        return source.stream().map(ScheduleMapper::mapFrom).collect(Collectors.toList());
    }
}
