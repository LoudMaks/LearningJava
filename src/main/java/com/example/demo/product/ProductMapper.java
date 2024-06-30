package com.example.demo.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.category.Category;
//
@Mapper(imports = {Category.class})
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	@Mapping(target = "category", expression = "java(new Category(dto.getCategory()))")
	Product fromDTO(ProductCreateDTO dto);
	
	@Mapping(target = "category", expression = "java(dto.getCategory() == null ? null : new Category(dto.getCategory()))")
	Product map(ProductEditDTO dto);
}
