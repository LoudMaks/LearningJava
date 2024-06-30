package com.example.demo.order;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {	
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
	
	Order map(OrderCreateDTO dto);
	Order map(OrderEditDTO dto);
	
}
