package com.atividadepratica.livro.exception;

public class LivroNotFoundException extends RuntimeException {
    public LivroNotFoundException(String message) {
        super(message);
    }
}
