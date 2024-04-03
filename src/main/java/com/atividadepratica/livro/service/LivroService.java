package com.atividadepratica.livro.service;

import org.springframework.stereotype.Service;
import com.atividadepratica.livro.repository.LivroRepository;
import com.atividadepratica.livro.entity.Livro;
import com.atividadepratica.livro.exception.LivroNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivroPorId(Long id) {
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
            return livroOptional.get();
        } else {
            throw new LivroNotFoundException("Livro não encontrado");
        }
    }

    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(Long id, Livro livro) {
        if (livroRepository.existsById(id)) {
            livro.setId(id); // Certifique-se de definir o ID corretamente para atualização.
            return livroRepository.save(livro);
        } else {
            throw new LivroNotFoundException("Livro não encontrado");
        }
    }

    public void excluirLivro(Long id) {
        if (livroRepository.existsById(id)) {
            livroRepository.deleteById(id);
        } else {
            throw new LivroNotFoundException("Livro não encontrado");
        }
    }
}
