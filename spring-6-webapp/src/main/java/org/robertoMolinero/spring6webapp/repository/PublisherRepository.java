package org.robertoMolinero.spring6webapp.repository;

import org.robertoMolinero.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
