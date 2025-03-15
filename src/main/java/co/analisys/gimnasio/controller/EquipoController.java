package co.analisys.gimnasio.controller;

import co.analisys.gimnasio.dto.EquipoDTO;
import co.analisys.gimnasio.service.interfaces.IServiceEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@Tag(name = "Equipos", description = "Gestión de equipos del gimnasio")
public class EquipoController {

    @Autowired
    private IServiceEquipo equipoService;

    @Operation(summary = "Obtener listados de equipos registrados",
            description = "Este endpoint permite obtener el listado de equipos registrados. " +
                    "Accesible solo para administradores y entrenadores.")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    @GetMapping
    public List<EquipoDTO> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @Operation(summary = "Registrar un nuevo equipo",
            description = "Este endpoint permite registrar un nuevo equipo en el sistema. " +
                    "Accesible solo para administradores.")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public EquipoDTO createEquipo(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.createEquipo(equipoDTO);
    }
}
