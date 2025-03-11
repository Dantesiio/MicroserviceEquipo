package co.analisys.gimnasio;

import co.analisys.gimnasio.dto.EquipoDTO;
import co.analisys.gimnasio.service.interfaces.IServiceEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IServiceEquipo equipoService;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        // Crear equipos de ejemplo (equipoDTO)
        EquipoDTO equipo1 = new EquipoDTO("E001", "Treadmill", "Cardio",2);
        EquipoDTO equipo2 = new EquipoDTO("E002", "Dumbbells", "Strength",3);
        EquipoDTO equipo3 = new EquipoDTO("E003", "Yoga Mat", "Flexibility",4);

        // Guardar los equipos en la base de datos
        equipoService.createEquipo(equipo1);
        equipoService.createEquipo(equipo2);
        equipoService.createEquipo(equipo3);

        System.out.println("Datos cargados correctamente en la base de datos.");
    }
}
