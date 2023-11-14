package co.edu.cue.CinemaGarcia.mapping.mappers;

import co.edu.cue.CinemaGarcia.domain.entities.Room;
import co.edu.cue.CinemaGarcia.mapping.dtos.RoomDto;

import java.util.List;
import java.util.stream.Collectors;

public class RoomMapper {
    public static RoomDto mapFrom(Room source){
        return new RoomDto(source.getId(),
                source.getNumber());
    }
    public static Room mapFrom(RoomDto source){
        return new Room(source.id(),
                source.number());
    }
    public static List<RoomDto> mapFrom(List<Room> source){
        return source.stream().map(RoomMapper::mapFrom).collect(Collectors.toList());
    }
}
