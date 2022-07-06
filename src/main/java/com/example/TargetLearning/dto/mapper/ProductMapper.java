package com.example.TargetLearning.dto.mapper;
import com.example.TargetLearning.dto.request.ProductMarginRequest;
import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductMarginResponse;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
import com.example.TargetLearning.entity.ProductMargin;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    Product fromRequestToEntity(ProductRequest productRequest);
    ProductRespone fromEntityToResponse(Product product);
    ProductMargin fromRequestToEntity(ProductMarginRequest productMarginRequest);
    ProductMarginResponse fromEntityToResponse(ProductMargin productMargin);
}
