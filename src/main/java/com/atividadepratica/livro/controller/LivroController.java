package com.atividadepratica.livro.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import com.atividadepratica.livro.service.LivroService;
import com.atividadepratica.livro.entity.Livro;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    @Operation(summary = "Obter todos os livros", description = "Recupera a lista de todos os livros disponíveis.")
    public List<Livro> getLivros() {
        return livroService.getLivros();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter livro por ID", description = "Recupera um livro com base no ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Livro encontrado", content = @Content(schema = @Schema(implementation = Livro.class)))
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    public Livro getLivroPorId(@PathVariable Long id) {
        return livroService.getLivroPorId(id);
    }

    @PostMapping
    @Operation(summary = "Adicionar novo livro", description = "Adiciona um novo livro à lista de livros.")
    @ApiResponse(responseCode = "201", description = "Livro adicionado", content = @Content(schema = @Schema(implementation = Livro.class)))
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.adicionarLivro(livro);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar livro por ID", description = "Atualiza um livro existente com base no ID fornecido.")
    @ApiResponse(responseCode = "200", description = "Livro atualizado", content = @Content(schema = @Schema(implementation = Livro.class)))
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.atualizarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir livro por ID", description = "Exclui um livro com base no ID fornecido.")
    @ApiResponse(responseCode = "204", description = "Livro excluído")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    public void excluirLivro(@PathVariable Long id) {
        livroService.excluirLivro(id);
    }
}
