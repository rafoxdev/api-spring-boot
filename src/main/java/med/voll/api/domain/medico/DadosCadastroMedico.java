package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.domain.endereco.DadosEndereco;

/**
 * @param nome
 * @param email
 * @param crm
 * @param especialidade
 * @param endereco
 *
 * SOBRE RECORD POR BAIXO DOS PANOS NO JAVA: (Disponível a partir do Java 16)
 *      Gera campos private e final para os componentes.
 *      Cria automaticamente um construtor, métodos getter, equals(), hashCode() e toString().
 *      Garante imutabilidade dos objetos.
 *      Restringe a herança.
 * Em resumo, o uso de record economiza tempo ao criar classes de dados simples e torna o código mais conciso e legível.
 *
 * SOBRE O USO DO BEAN VALIDATION:
 *      A utilização de anotations sobre cada atributo, permite validar determinadas regras sem utilizar métodos do tipo if e etc.
 */
public record DadosCadastroMedico(
        @NotNull
        @NotEmpty
        String nome,

        @NotBlank // @NotBlank já valida se não é nulo e nem vazio. (Válido somente para tipo String)
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // Define que o "crm" é uma string que contém APENAS números, com no minimo 4 e máximo 6 digitos.
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco) { // Como DadosEndereco é outro DTO, o uso do @Valid é para validar que esse atributo vai possuir validações feitas pelo Bean Validation.
}
