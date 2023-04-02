package com.thesis.offer.repository;

import com.thesis.offer.model.Offer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @EntityGraph(attributePaths = {"products"})
    List<Offer> findAllOrderByOrder(Pageable pageable);
}
