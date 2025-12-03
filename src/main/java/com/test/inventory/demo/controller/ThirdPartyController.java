package com.test.inventory.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.inventory.demo.dto.ThirdPartyProductDto;

@RestController
@RequestMapping("/my-api")
public class ThirdPartyController {

    private final RestTemplate restTemplate;

    public ThirdPartyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/data")
    public ResponseEntity<?> getData() {
        String url = "https://fakestoreapi.com/products";
        ThirdPartyProductDto[] externalProducts = restTemplate.getForObject(url, ThirdPartyProductDto[].class);

        return ResponseEntity.ok(externalProducts);
    }
}
