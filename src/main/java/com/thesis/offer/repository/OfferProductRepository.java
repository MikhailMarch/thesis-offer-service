package com.thesis.offer.repository;

import com.thesis.offer.model.OfferProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OfferProductRepository extends JpaRepository<OfferProduct, Long> {

    List<OfferProduct> findAllByOfferIdIn(Collection<Long> offerIds);
}
