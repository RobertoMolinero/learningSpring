package org.robertomolinero.spring6restmvc.mapper;

import org.mapstruct.Mapper;
import org.robertomolinero.spring6restmvc.entity.Beer;
import org.robertomolinero.spring6restmvc.model.BeerDto;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beerDto);

    BeerDto beerToBeerDto(Beer beer);
}
