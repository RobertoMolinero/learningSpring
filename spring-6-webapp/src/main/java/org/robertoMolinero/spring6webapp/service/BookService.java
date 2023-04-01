package org.robertoMolinero.spring6webapp.service;

import org.robertoMolinero.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
