package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {

   @JsonProperty("isbn")
    @NotBlank(message = "ISBN do livro não pode ser vazio")
    private String isbn;

    @JsonProperty("tituloLivro")
    @NotBlank(message = "Titulo do livro não pode ser vazio")
    private String tituloLivro;

    @JsonProperty("id_Autor")
    @NotNull(message = "Autor do livro não pode ser nulo")
    private Long codigoAutor;

    @JsonProperty("anoLancamento")
    @NotNull(message = "Ano de lançamento do livro não pode ser nulo")
    private Integer anoLancamento;

    @JsonProperty("edicao")
    @NotBlank(message = "A edição do livro não pode ser vazia")
    private String edicao;
    
}
