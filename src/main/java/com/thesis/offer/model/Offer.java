package com.thesis.offer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Offer {

    @Id
    private Long id;

    private String title;

    private String order;
}
