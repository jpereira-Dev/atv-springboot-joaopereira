package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {

    @JsonProperty("tituloLivro")
    @NotBlank(message = "Nome do livro não pode ser vazio")
    private String tituloLivro;

    @JsonProperty("autor")
    @NotBlank(message = "Autor do livro não pode ser vazio")
    private Long id_autor;

    @JsonProperty("ano")
    @NotBlank(message = "ano de lançamento não pode ser vazio")
    private Integer anoLancamento;

    @JsonProperty("nacionalidade")
    @NotBlank(message = "Nacionalidade do autor não pode ser vazia")
    private String nacionalidade;
    
}
