package com.demo.product.dto.mapper;

import com.demo.common.utils.DemoDateTime;
import com.demo.product.dto.DealDetail;
import com.demo.product.entity.DealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by HoYoung on 2023/02/28.
 */
@Mapper(componentModel = "spring", imports = {DemoDateTime.class})
public interface DealMapper {

    @Mapping(target = "displayStartAt", expression = "java(DemoDateTime.toEpochMilli(dealEntity.getDisplayStartAt()))")
    @Mapping(target = "displayEndAt", expression = "java(DemoDateTime.toEpochMilli(dealEntity.getDisplayEndAt()))")
    DealDetail from(DealEntity dealEntity);
}
