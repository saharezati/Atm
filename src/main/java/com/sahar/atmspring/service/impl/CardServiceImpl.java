package com.sahar.atmspring.service.impl;

import com.sahar.atmspring.Exceptions.NotfoundException;
import com.sahar.atmspring.dto.CardDto;
import com.sahar.atmspring.entity.Card;
import com.sahar.atmspring.mapper.CardMapper;
import com.sahar.atmspring.repository.CardRepository;
import com.sahar.atmspring.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public void saveOrUpdate(CardDto cardDto){
        cardRepository.save(cardMapper.toEntity(cardDto));
    }
    @Override
    public List<CardDto>findAll(){
        return cardMapper.toDto(cardRepository.findAll());
    }
    @Override
    public  CardDto findbayid(Long id){
        return  cardMapper.toDto(cardRepository.findById(id).orElseThrow( ()->{
            throw  new NotfoundException("card not found");
        } ));
    }

    @Override
    public  void delete(CardDto cardDto){
        cardRepository.delete(cardMapper.toEntity(cardDto));
    }
    @Override
    public  void  deletebyid(Long id){
        cardRepository.deleteById(id);
    }
    @Override
    public  CardDto findbycardnumbefr(String cardnumber){
        return cardMapper.toDto(cardRepository.findByCardNumber(cardnumber).orElseThrow( ()->{
            throw new NotfoundException("card not found");
        } ));
    }

}
