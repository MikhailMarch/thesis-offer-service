package com.thesis.offer.dto.offer;

import com.thesis.offer.dto.product.OfferProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedOfferDto extends OfferDto{

    private Long id;

    private String title;

    private List<OfferProductDto> productDtoList;
}
