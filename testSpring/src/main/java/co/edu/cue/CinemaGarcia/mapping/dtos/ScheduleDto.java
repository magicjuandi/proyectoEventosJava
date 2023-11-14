package co.edu.cue.CinemaGarcia.mapping.dtos;

import java.time.LocalDateTime;

public record ScheduleDto(String id,
                          String name,
                          LocalDateTime startTime,
                          LocalDateTime endTime) {
}
