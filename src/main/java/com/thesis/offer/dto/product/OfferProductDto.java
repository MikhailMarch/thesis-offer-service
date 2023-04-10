package com.thesis.offer.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class OfferProductDto {

    private Long id;

    private Integer ordering;

    private Integer sellPrice;

    private Double rating;
}
