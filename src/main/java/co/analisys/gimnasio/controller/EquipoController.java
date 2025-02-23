package co.analisys.gimnasio.controller;

import co.analisys.gimnasio.dto.EquipoDTO;
import co.analisys.gimnasio.service.IServiceEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private IServiceEquipo equipoService;

    @GetMapping
    public List<EquipoDTO> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @PostMapping
    public EquipoDTO createEquipo(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.createEquipo(equipoDTO);
    }
}
