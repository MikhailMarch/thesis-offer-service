package com.thesis.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferProductDto {

    private Long id;

    private Long productId;

    private Integer ordering;

    private Integer sellPrice;

    private Double rating;
}
