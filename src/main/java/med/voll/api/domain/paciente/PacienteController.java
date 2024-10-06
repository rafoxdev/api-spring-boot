package med.voll.api.domain.paciente;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
        System.out.println("Paciente recebido: " + paciente);
        Paciente salvarPaciente = pacienteRepository.save(paciente);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvarPaciente);
    }

}
