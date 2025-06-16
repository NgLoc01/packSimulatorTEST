package com.example.ChatRoom;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ScryfallService scryfallService;

    public ApiController(ScryfallService scryfallService) {
        this.scryfallService = scryfallService;
    }

    @GetMapping("/card")
    public ResponseEntity<CardResponse> getCard() {
        return ResponseEntity.ok(scryfallService.fetchRandomCard());
    }
}
