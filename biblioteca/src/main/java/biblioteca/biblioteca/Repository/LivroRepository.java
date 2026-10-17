package biblioteca.biblioteca.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblioteca.Model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long> {

    Optional<Livro> findByIsbn(String isbn);
    Optional<Livro> findByTitulo(String titulo);

}
