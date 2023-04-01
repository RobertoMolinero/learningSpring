package org.robertomolinero.spring6restmvc.service;

import org.robertomolinero.spring6restmvc.model.BeerDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {

    List<BeerDto> listBeers();

    Optional<BeerDto> getBeerById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    Optional<BeerDto> updateBeerById(UUID beerId, BeerDto beerDto);

    Boolean deleteBeerById(UUID beerId);

    BeerDto patchBeerById(UUID beerId, BeerDto beerDto);
}
