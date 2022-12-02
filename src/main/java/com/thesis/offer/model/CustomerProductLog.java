package com.thesis.offer.model;

import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

public class CustomerProductLog {

    @Id
    private Long id;

    private Long productId;

    private Long customerId;

    @CreationTimestamp
    private Timestamp dateAccessed;
}
