package org.robertoMolinero.spring6webapp.repository;

import org.robertoMolinero.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
