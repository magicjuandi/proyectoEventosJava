package co.edu.cue.CinemaGarcia.mapping.mappers;

import co.edu.cue.CinemaGarcia.domain.entities.Movie;
import co.edu.cue.CinemaGarcia.mapping.dtos.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {
    public static MovieDto mapFrom(Movie source){
        return new MovieDto(source.getId(),
                source.getName(),
                source.getRoom());
    }
    public static Movie mapFrom(MovieDto source){
        return new Movie(source.id(),
                source.name(),
                source.room());
    }
    public static List<MovieDto> mapFrom(List<Movie> source){
        return source.stream().map(MovieMapper::mapFrom).collect(Collectors.toList());
    }
}
