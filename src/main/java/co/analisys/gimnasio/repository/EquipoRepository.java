package co.analisys.gimnasio.repository;
import co.analisys.gimnasio.model.Equipo;

import co.analisys.gimnasio.model.EquipoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, EquipoId> {
    List<Equipo> findAll();
}