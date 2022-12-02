package com.thesis.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

    private Long id;

    private String title;

    private List<OfferProductDto> productDtoList;
}
