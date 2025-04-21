package co.analisys.gimnasio.service.impl;

import co.analisys.gimnasio.dto.EquipoDTO;
import co.analisys.gimnasio.model.Equipo;
import co.analisys.gimnasio.model.EquipoId;
import co.analisys.gimnasio.repository.EquipoRepository;
import co.analisys.gimnasio.service.interfaces.IServiceEquipo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements IServiceEquipo {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<EquipoDTO> getAllEquipos() {
        return equipoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO createEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = convertToEntity(equipoDTO);
        equipo = equipoRepository.save(equipo);

        // 📨 Enviar mensaje a RabbitMQ
        rabbitTemplate.convertAndSend(
                "gimnasio.exchange",
                "equipo.nuevo",
                equipoDTO
        );

        return convertToDTO(equipo);
    }

    private EquipoDTO convertToDTO(Equipo equipo) {
        return new EquipoDTO(
                equipo.getId().getEquipoIdValue(),
                equipo.getNombre(),
                equipo.getDescripcion(),
                equipo.getCantidad()
        );
    }

    private Equipo convertToEntity(EquipoDTO dto) {
        return new Equipo(
                new EquipoId(dto.getEquipoId()),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getCantidad()
        );
    }
}
