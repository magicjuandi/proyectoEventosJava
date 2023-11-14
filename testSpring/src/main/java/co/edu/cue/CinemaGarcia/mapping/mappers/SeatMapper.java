package co.edu.cue.CinemaGarcia.mapping.mappers;

import co.edu.cue.CinemaGarcia.domain.entities.Seat;
import co.edu.cue.CinemaGarcia.mapping.dtos.SeatDto;

import java.util.List;
import java.util.stream.Collectors;

public class SeatMapper {
    public static SeatDto mapFrom(Seat source){
        return new SeatDto(source.getId(),
                source.getPosition(),
                source.getRoom());
    }
    public static Seat mapFrom(SeatDto source){
        return new Seat(source.id(),
                source.position(),
                source.room());
    }
    public static List<SeatDto> mapFrom(List<Seat> source) {
        return source.stream().map(SeatMapper::mapFrom).collect(Collectors.toList());
    }
}
