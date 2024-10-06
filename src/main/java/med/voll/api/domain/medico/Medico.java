package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter // Gera os métodos Getter
@NoArgsConstructor // Gera construtor default
@AllArgsConstructor // Gera construtor que recebe todos os atributos
@EqualsAndHashCode(of = "id") // Gera apenas em cima do ID
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded // Usando essa anotation e passando "Embeddable" na classe Endereço, torna os atributos de endereço acessiveis na table "medicos".
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dadosCadastroMedico) {
        this.nome = dadosCadastroMedico.nome();
        this.email = dadosCadastroMedico.email();
        this.telefone = dadosCadastroMedico.telefone();
        this.crm = dadosCadastroMedico.crm();
        this.especialidade = dadosCadastroMedico.especialidade();
        this.endereco = new Endereco(dadosCadastroMedico.endereco());
        this.ativo = Boolean.TRUE;
    }

    public void atualizarInformacoesMedico(DadosAtualizacaoMedico dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoesEndereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = Boolean.FALSE;
    }
}
