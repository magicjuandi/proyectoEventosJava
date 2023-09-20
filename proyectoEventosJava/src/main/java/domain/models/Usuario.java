package domain.models;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Usuario {
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String estado;
}
