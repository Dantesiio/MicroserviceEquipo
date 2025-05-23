package co.analisys.gimnasio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    @EmbeddedId
    private EquipoId id;
    private String nombre;
    private String descripcion;
    private int cantidad;
}
