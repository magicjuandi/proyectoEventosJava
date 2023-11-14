package co.edu.cue.CinemaGarcia.mapping.dtos;

import co.edu.cue.CinemaGarcia.domain.entities.Client;
import co.edu.cue.CinemaGarcia.domain.entities.Movie;
import co.edu.cue.CinemaGarcia.domain.entities.Schedule;
import co.edu.cue.CinemaGarcia.domain.entities.Seat;

public record ReservationDto(String id,
                             Client client,
                             Movie movie,
                             Seat seat,
                             Schedule schedule) {
}
