package com.thesis.offer.dto.product;

import com.thesis.offer.dto.feedback.ProductFeedbackDto;
import com.thesis.offer.dto.offer.OfferDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedProductDto extends OfferProductDto{

    private List<ProductFeedbackDto> feedbacks;

    private OfferDto offer;
}
