package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.UserDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class UserServiceImpl implements Service<UserDto> {
    @Override
    public List<UserDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public UserDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(UserDto userDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
