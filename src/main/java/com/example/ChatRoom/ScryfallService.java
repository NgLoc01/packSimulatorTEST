package com.example.ChatRoom;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScryfallService {
    private final RestTemplate restTemplate = new RestTemplate();

    public CardResponse fetchRandomCard() {
        return restTemplate.getForObject("https://api.scryfall.com/cards/random", CardResponse.class);
    }
}