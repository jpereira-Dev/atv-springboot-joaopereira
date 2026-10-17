package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {

     @JsonProperty("ISBN")
    private String isbn;

    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @JsonProperty("autor")
    private Long id_autor;

    @JsonProperty("ano")
    private Integer anoLancamento;

    @JsonProperty("edicao")
    private String edicao;


    
}
