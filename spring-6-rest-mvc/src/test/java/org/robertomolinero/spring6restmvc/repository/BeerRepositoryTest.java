package org.robertomolinero.spring6restmvc.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.robertomolinero.spring6restmvc.entity.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void saveAndFlush() {
        Beer leikeimLandbier = beerRepository.save(Beer.builder().beerName("Leikeim Landbier").build());

        Assertions.assertNotNull(leikeimLandbier);
        Assertions.assertNotNull(leikeimLandbier.getId());
    }
}