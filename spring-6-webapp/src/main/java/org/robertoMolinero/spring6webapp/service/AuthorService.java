package org.robertoMolinero.spring6webapp.service;

import org.robertoMolinero.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
