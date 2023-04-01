package org.robertomolinero.spring6restmvc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.robertomolinero.spring6restmvc.model.BeerDto;
import org.robertomolinero.spring6restmvc.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@RestController
public class BeerController {

    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    private final BeerService beerService;

    @GetMapping(BEER_PATH)
    public List<BeerDto> listBeers() {
        log.debug("Method 'org.robertomolinero.spring6restmvc.controller.BeerController.listBeers' was called.");
        return beerService.listBeers();
    }

    @GetMapping(BEER_PATH_ID)
    public BeerDto getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("Method 'org.robertomolinero.spring6restmvc.controller.BeerController.getBeerById' was called.");
        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(BEER_PATH)
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {
        log.debug("Method 'org.robertomolinero.spring6restmvc.controller.BeerController.saveNewBeer' was called.");
        BeerDto savedBeerDto = beerService.saveNewBeer(beerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", BEER_PATH + "/" + savedBeerDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        if (beerService.updateBeerById(beerId, beerDto).isEmpty()) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId) {
        if (!beerService.deleteBeerById(beerId)) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity patchBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.patchBeerById(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
