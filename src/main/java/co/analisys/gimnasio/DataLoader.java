package co.analisys.gimnasio;



import co.analisys.gimnasio.model.Equipo;
import co.analisys.gimnasio.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EquipoRepository equipoRepository;

    @Override
    public void run(String... args) throws Exception {
        equipoRepository.save(new Equipo(1, "Mancuerna 10kg", "Par de mancuernas", 10));
        equipoRepository.save(new Equipo(2, "Bicicleta Estática", "Bicicleta para cardio", 5));
        equipoRepository.save(new Equipo(3, "Cuerda para saltar", "Cuerda de velocidad", 15));

        System.out.println("Datos de prueba cargados exitosamente.");

    }
}