package co.edu.cue.CinemaGarcia.mapping.dtos;

import co.edu.cue.CinemaGarcia.domain.entities.Room;

public record MovieDto(String id,
                       String name,
                       Room room) {
}
