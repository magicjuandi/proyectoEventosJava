package domain.models;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Historico {
    private Long id;
    private Usuario usuario;
    private int intento;
    private LocalDate fecha;
    private LocalTime tiempo;
    private String indicador;
}
