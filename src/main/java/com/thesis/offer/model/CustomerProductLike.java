package com.thesis.offer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerProductLike {

    @Id
    private Long id;

    private Long customerId;

    private Long productId;
}
