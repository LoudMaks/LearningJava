package com.example.demo.order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StatusMapper {
	StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);
	
	Status map(StatusCreateDTO dto);
	Status map(StatusEditDTO dto);

}
