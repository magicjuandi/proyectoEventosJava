package domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    private String estado;
}
