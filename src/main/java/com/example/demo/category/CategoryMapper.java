package com.example.demo.category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(imports = (Category.class))
public interface CategoryMapper {
	
	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	@Mapping(target = "parentCategory", expression = "java((dto.getParentCategory()==null) ? null : (new Category(dto.getParentCategory())))")
	Category fromDTO(CategoryCreateDTO dto);
	@Mapping(target = "parentCategory", expression = "java((dto.getParentCategory()==null) ? null : (new Category(dto.getParentCategory())))")
	Category map(CategoryEditDTO dto);

}
