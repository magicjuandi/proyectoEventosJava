package co.edu.cue.CinemaGarcia.mapping.mappers;

import co.edu.cue.CinemaGarcia.domain.entities.User;
import co.edu.cue.CinemaGarcia.mapping.dtos.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto mapFrom(User source){
        return new UserDto(source.getId(),
                source.getUsername(),
                source.getPassword());
    }
    public static User mapFrom(UserDto source){
        return new User(source.id(),
                source.username(),
                source.password());
    }
    public static List<UserDto> mapFrom(List<User> source){
        return source.stream().map(UserMapper::mapFrom).collect(Collectors.toList());
    }
}
