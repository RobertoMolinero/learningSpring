package org.robertoMolinero.spring6webapp.repository;

import org.robertoMolinero.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
