package com.alexanderbaranov.productmanagement.service;

import com.alexanderbaranov.productmanagement.model.Item;
import com.alexanderbaranov.productmanagement.service.response.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ItemMapper {

    ItemDto toItemDto(Item item);

    List<ItemDto> toItemDto(List<Item> item);

    void toItem (@MappingTarget Item item, ItemDto itemDto);

    Item toItem(ItemDto itemDto);

}
