package biblioteca.biblioteca.Model;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_livro")
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;


    @Column(name = "ISBN", nullable = false)
    @JsonProperty("ISBN")
    private String isbn;

    @Column(name = "tituloLivro", nullable = false)
    @JsonProperty("titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor")
    @JsonProperty("autor")
    private Autor autor;

    @Column(name = "ano")
    @JsonProperty("ano")
    private Integer ano;

    @Column(name = "edicao", nullable = false)
    @JsonProperty("edicao")
    private String edicao;






    

    


    
}
