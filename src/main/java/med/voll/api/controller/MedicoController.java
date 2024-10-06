package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired // Cria a injeção de dependências
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional // O uso dessa anotation de escrita é necessária ao fazer fazer alguma ação como: create, insert, update, delete.
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dadosCadastroMedico);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico)); // codigo 201 do protocolo HTTP
    }

    @GetMapping
    // Se não definirmos atributos como tamanho, ordenação e etc e passar direto na URL, vai sobrescrever o @PageableDefault.
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemMedico> page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page); // codigo 200 do protocolo HTTP
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoesMedico(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); // codigo 200 do protocolo HTTP
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
       var medico = medicoRepository.getReferenceById(id);
       medico.excluir();

       return ResponseEntity.noContent().build(); // codigo 204 do protocolo HTTP
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); // codigo 200 do protocolo HTTP
    }
}
