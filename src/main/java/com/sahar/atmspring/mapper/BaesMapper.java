package com.sahar.atmspring.mapper;

import java.util.List;

public interface BaesMapper<E,T>{
    E toEntity(T t);
    T toDto(E e);
    List<E>toEntity(List<T>t);
    List<T>toDto(List<E>e);
}
