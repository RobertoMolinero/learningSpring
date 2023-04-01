package org.robertomolinero.spring6restmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.robertomolinero.spring6restmvc.model.BeerDto;
import org.robertomolinero.spring6restmvc.model.BeerStyle;
import org.robertomolinero.spring6restmvc.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<BeerDto> beerArgumentCaptor;

    @Test
    void getBeerById() throws Exception {
        UUID uuid = UUID.fromString("8c1df8e2-7515-4b4b-ae26-1c16d69439f2");

        BeerDto galaxyCat = BeerDto.builder()
                .id(uuid)
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        given(beerService.getBeerById(uuid)).willReturn(Optional.of(galaxyCat));

        mockMvc.perform(get(BeerController.BEER_PATH_ID, uuid)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(galaxyCat.getId().toString())))
                .andExpect(jsonPath("$.beerName", is(galaxyCat.getBeerName())));
    }

    @Test
    void getBeerByIdNotFound() throws Exception {
        given(beerService.getBeerById(any(UUID.class))).willReturn(Optional.empty());

        mockMvc.perform(get(BeerController.BEER_PATH_ID, UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Test
    void listBeers() throws Exception {
        BeerDto galaxyCat = BeerDto.builder()
                .id(UUID.fromString("8c1df8e2-7515-4b4b-ae26-1c16d69439f2"))
                .beerName("Galaxy Cat")
                .build();

        BeerDto crank = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Crank")
                .build();

        BeerDto sunshineCity = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Sunshine City")
                .build();

        given(beerService.listBeers()).willReturn(List.of(galaxyCat, crank, sunshineCity));

        mockMvc.perform(get(BeerController.BEER_PATH)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void saveNewBeer() throws Exception {
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

        given(beerService.saveNewBeer(any(BeerDto.class))).willReturn(freiberger);

        mockMvc.perform(post(BeerController.BEER_PATH)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(freiberger)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void updateBeerById() throws Exception {
        UUID uuid = UUID.fromString("0419d9d7-2679-446b-b198-de377c2ffc62");

        BeerDto freiberger = BeerDto.builder()
                .id(uuid)
                .version(1)
                .beerName("Freiberger Urpils 1863")
                .beerStyle(BeerStyle.PILSNER)
                .upc("347541")
                .price(new BigDecimal("3.55"))
                .quantityOnHand(500)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        given(beerService.updateBeerById(uuid, freiberger)).willReturn(Optional.of(freiberger));

        mockMvc.perform(put(BeerController.BEER_PATH_ID, uuid)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(freiberger)))
                .andExpect(status().isNoContent());

        verify(beerService).updateBeerById(uuid, freiberger);
    }

    @Test
    void deleteBeerById() throws Exception {
        UUID uuid = UUID.fromString("8c1df8e2-7515-4b4b-ae26-1c16d69439f2");
        given(beerService.deleteBeerById(uuid)).willReturn(Boolean.TRUE);

        mockMvc.perform(delete(BeerController.BEER_PATH_ID, uuid)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(beerService).deleteBeerById(uuidArgumentCaptor.capture());
        Assertions.assertEquals(uuid, uuidArgumentCaptor.getValue());
    }

    @Test
    void patchBeerById() throws Exception {
        UUID uuid = UUID.fromString("0419d9d7-2679-446b-b198-de377c2ffc62");

        Map<String, Object> beerMap = new HashMap<>();
        beerMap.put("beerName", "New Name");

        mockMvc.perform(patch(BeerController.BEER_PATH_ID, uuid)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beerMap)))
                .andExpect(status().isNoContent());

        verify(beerService).patchBeerById(uuidArgumentCaptor.capture(), beerArgumentCaptor.capture());

        Assertions.assertEquals(uuid, uuidArgumentCaptor.getValue());
        Assertions.assertEquals(beerMap.get("beerName"), beerArgumentCaptor.getValue().getBeerName());
    }
}