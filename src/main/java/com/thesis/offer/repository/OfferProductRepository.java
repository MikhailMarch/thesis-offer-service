package com.thesis.offer.repository;

import com.thesis.offer.model.OfferProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferProductRepository extends JpaRepository<OfferProduct, Long> {
}
