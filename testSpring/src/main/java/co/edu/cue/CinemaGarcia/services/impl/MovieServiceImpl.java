package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.MovieDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class MovieServiceImpl implements Service<MovieDto> {

    @Override
    public List<MovieDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public MovieDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(MovieDto movieDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
