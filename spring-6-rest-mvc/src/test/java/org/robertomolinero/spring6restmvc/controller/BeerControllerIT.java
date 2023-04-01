package org.robertomolinero.spring6restmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.robertomolinero.spring6restmvc.entity.Beer;
import org.robertomolinero.spring6restmvc.mapper.BeerMapper;
import org.robertomolinero.spring6restmvc.model.BeerDto;
import org.robertomolinero.spring6restmvc.model.BeerStyle;
import org.robertomolinero.spring6restmvc.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class BeerControllerIT {

    @Autowired
    BeerController beerController;

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerMapper beerMapper;

    @Test
    void getBeerByIdNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> beerController.getBeerById(UUID.randomUUID()));
    }

    @Test
    void getBeerById() {
        Beer beer = beerRepository.findAll().get(0);
        BeerDto beerById = beerController.getBeerById(beer.getId());

        Assertions.assertNotNull(beerById);
    }

    @Test
    void listBeers() {
        List<BeerDto> beerDtos = beerController.listBeers();

        Assertions.assertEquals(3, beerDtos.size());
    }

    @Transactional
    @Rollback
    @Test
    void listEmptyList() {
        beerRepository.deleteAll();
        List<BeerDto> beerDtos = beerController.listBeers();

        Assertions.assertEquals(0, beerDtos.size());
    }

    @Transactional
    @Rollback
    @Test
    void saveNewBeer() {
        BeerDto freiberger = BeerDto.builder()
                .id(UUID.fromString("0419d9d7-2679-446b-b198-de377c2ffc62"))
                .version(1)
                .beerName("Freiberger Urpils 1863")
                .beerStyle(BeerStyle.PILSNER)
                .upc("347541")
                .price(new BigDecimal("3.55"))
                .quantityOnHand(500)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        ResponseEntity responseEntity = beerController.saveNewBeer(freiberger);

        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Assertions.assertNotNull(responseEntity.getHeaders().getLocation());

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUuid = UUID.fromString(locationUUID[4]);

        Beer beer = beerRepository.findById(savedUuid).get();
        Assertions.assertNotNull(beer);
    }

    @Transactional
    @Rollback
    @Test
    void updateBeerById() {
        Beer beer = beerRepository.findAll().get(0);
        BeerDto beerDto = beerMapper.beerToBeerDto(beer);

        beerDto.setId(null);
        beerDto.setVersion(null);
        beerDto.setBeerName("Updated");

        ResponseEntity responseEntity = beerController.updateBeerById(beer.getId(), beerDto);

        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

        Beer updatedBeer = beerRepository.findById(beer.getId()).get();

        Assertions.assertEquals("Updated", updatedBeer.getBeerName());
    }

    @Test
    void updateBeerByIdNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> beerController.updateBeerById(UUID.randomUUID(), BeerDto.builder().build()));
    }

    @Transactional
    @Rollback
    @Test
    void deleteBeerById() {
        Beer beer = beerRepository.findAll().get(0);
        ResponseEntity responseEntity = beerController.deleteBeerById(beer.getId());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());

        Optional<Beer> byId = beerRepository.findById(beer.getId());
        Assertions.assertEquals(Optional.empty(), byId);
    }

    @Test
    void deleteBeerByIdNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> beerController.deleteBeerById(UUID.randomUUID()));
    }
}