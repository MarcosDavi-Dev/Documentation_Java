package com.atividadepratica.livro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.atividadepratica.livro.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Você pode adicionar métodos personalizados de consulta aqui, se necessário.
}
