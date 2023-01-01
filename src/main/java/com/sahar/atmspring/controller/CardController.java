package com.sahar.atmspring.controller;

import com.sahar.atmspring.dto.CardDto;
import com.sahar.atmspring.service.CardService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> findall() {
        List<CardDto> cardDto = cardService.findAll( );
        return ResponseEntity.ok(cardDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> findbyid(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(cardService.findbayid(id));

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CardDto cardDto) {
        cardService.saveOrUpdate(cardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletebyid(@PathVariable(name = "id")Long id){
        cardService.deletebyid(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
