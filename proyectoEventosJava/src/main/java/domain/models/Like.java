package domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Like {

    private Usuario usuario;
    private Producto producto;
    private String estado;
}
