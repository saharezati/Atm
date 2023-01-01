package com.sahar.atmspring.service;

import com.sahar.atmspring.dto.CardDto;
import com.sahar.atmspring.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    void saveOrUpdate(CardDto cardDto);

    List<CardDto> findAll();

    CardDto findbayid(Long id);


    void delete(CardDto cardDto);

    void  deletebyid(Long id);

    CardDto findbycardnumbefr(String cardnumber);
}
