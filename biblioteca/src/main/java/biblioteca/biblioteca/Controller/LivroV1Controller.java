package biblioteca.biblioteca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Service.LivroCrudService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping (value = "/v1/livros", produces = "application/json")
public class LivroV1Controller {

    @Autowired 
    private LivroCrudService livroCrudService;

    @PostMapping("")
    public ResponseEntity<LivroResponseDto> criarLivro(@RequestBody @Valid LivroPostPutDto livroPostPutDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCrudService.criarLivro(livroPostPutDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(@PathVariable Long id, @RequestBody @Valid LivroPostPutDto livroPostPutDto) {
        return ResponseEntity.status(HttpStatus.OK).body(livroCrudService.atualizarLivro(id, livroPostPutDto));
    }

    @GetMapping ("/isbn/{isbn}")
    public ResponseEntity<LivroResponseDto> buscarLivroPorISBN(@PathVariable String isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(livroCrudService.buscarLivroPorISBN(isbn));
    }

    @GetMapping ("/titulo/{titulo}")
    public ResponseEntity<LivroResponseDto> buscarLivroPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.status(HttpStatus.OK).body(livroCrudService.buscarLivroPorTitulo(titulo));
    }

    @GetMapping ("")
    public ResponseEntity<List<LivroResponseDto>> listarTodosLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroCrudService.listarTodosLivros());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroCrudService.deletarLivro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    
}
