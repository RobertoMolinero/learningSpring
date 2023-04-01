package org.robertomolinero.spring6restmvc.bootstrap;

import lombok.RequiredArgsConstructor;
import org.robertomolinero.spring6restmvc.entity.Beer;
import org.robertomolinero.spring6restmvc.model.BeerStyle;
import org.robertomolinero.spring6restmvc.repository.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) {
        Beer galaxyCat = Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        Beer crank = Beer.builder()
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        Beer sunshineCity = Beer.builder()
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        beerRepository.saveAll(List.of(galaxyCat, crank, sunshineCity));
    }
}
