package biblioteca.biblioteca.Service;


import java.util.List;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    LivroResponseDto atualizarLivro(Long id, LivroPostPutDto livroPostPutDto);

    LivroResponseDto buscarLivroPorISBN(String isbn);

    LivroResponseDto buscarLivroPorTitulo(String titulo);

    List<LivroResponseDto> listarTodosLivros();

    void deletarLivro(Long id);
    
    
}
