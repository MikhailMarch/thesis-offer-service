package com.thesis.offer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OfferProduct {
    @Id
    private Long id;

    private Long productId;

    private Integer ordering;

    @ManyToOne
    private Offer offerId;
}
