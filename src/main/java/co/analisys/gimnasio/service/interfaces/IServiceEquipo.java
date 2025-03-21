package co.analisys.gimnasio.service.interfaces;

import co.analisys.gimnasio.dto.EquipoDTO;
import java.util.List;

public interface IServiceEquipo {
    List<EquipoDTO> getAllEquipos();
    EquipoDTO createEquipo(EquipoDTO equipoDTO);
}
