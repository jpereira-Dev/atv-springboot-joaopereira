package biblioteca.biblioteca.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import biblioteca.biblioteca.Dto.AutorResponseDto;
import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LivroRepository;

@Service 
public class LivroCrudPadraoService implements LivroCrudService {

     @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {

        Livro livro = new Livro();
        Autor autor = autorRepository.findById(livroPostPutDto.getCodigoAutor())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));

        livro.setIsbn(livroPostPutDto.getIsbn());
        livro.setTitulo(livroPostPutDto.getTituloLivro());
        livro.setAno(livroPostPutDto.getAnoLancamento());
        livro.setEdicao(livroPostPutDto.getEdicao());
        livro.setAutor(autor);

        return toResponse(livroRepository.save(livro));
    }

    @Override
    public LivroResponseDto atualizarLivro(Long id, LivroPostPutDto livroPostPutDto) {
        
        Livro livroexistente = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
                
        modelMapper.map(livroPostPutDto, livroexistente); 
        return toResponse(livroRepository.save(livroexistente));
    }

    @Override
    public LivroResponseDto buscarLivroPorISBN(String isbn) {

        Livro livro = livroRepository.findByIsbn(isbn).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
        return toResponse(livro);
    }

    @Override
    public LivroResponseDto buscarLivroPorTitulo(String titulo) {
        
        Livro livro = livroRepository.findByTitulo(titulo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
        return toResponse(livro);
    }

    @Override
    public List<LivroResponseDto> listarTodosLivros() {
        
        return livroRepository.findAll()
                .stream()
                .map(livro -> toResponse(livro))
                .toList();
    }

    @Override
    public void deletarLivro(Long id) {

        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
        livroRepository.delete(livro);

    }


    private LivroResponseDto toResponse(Livro livro) {
    return LivroResponseDto.builder()
            .isbn(livro.getIsbn())
            .tituloLivro(livro.getTitulo())
            .id_autor(livro.getAutor().getId())
            .anoLancamento(livro.getAno())
            .edicao(livro.getEdicao())
            .build();
}


    
}
