package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacoesEndereco(DadosEndereco dados) {
        if(this.logradouro != null) {
            this.logradouro = dados.logradouro();
        }
        if(this.bairro != null) {
            this.bairro = dados.bairro();
        }
        if(this.cep != null) {
            this.cep = dados.cep();
        }
        if(this.uf != null) {
            this.uf = dados.uf();
        }
        if(this.cidade != null) {
            this.cidade = dados.cidade();
        }
        if(this.numero != null) {
            this.numero = dados.numero();
        }
        if(this.complemento != null) {
            this.complemento = dados.complemento();
        }
    }
}
