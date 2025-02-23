package co.analisys.gimnasio.service;

import co.analisys.gimnasio.dto.EquipoDTO;
import java.util.List;

public interface IServiceEquipo {
    List<EquipoDTO> getAllEquipos();
    EquipoDTO createEquipo(EquipoDTO equipoDTO);
}
