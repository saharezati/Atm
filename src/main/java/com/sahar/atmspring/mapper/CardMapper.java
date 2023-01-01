package com.sahar.atmspring.mapper;

import com.sahar.atmspring.dto.CardDto;
import com.sahar.atmspring.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends BaesMapper<Card, CardDto>{
}
