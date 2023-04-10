package com.thesis.offer.repository;

import com.thesis.offer.model.OfferProduct;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface OfferProductRepository extends JpaRepository<OfferProduct, Long> {

    List<OfferProduct> findAllByOfferIdIn(Collection<Long> offerIds);

    @EntityGraph(attributePaths = {"offer"})
    Optional<OfferProduct> findByProductId(Long productId);

    @Query(nativeQuery = true, value = "" +
            "SELECT of.product_id as productId," +
            "       o.id          as offerId," +
            "       o.title       as title " +
            "FROM offer_product of " +
            "   JOIN offer o " +
            "WHERE of.product_id in :productIds")
    <T> List<T> getProductOffers(@Param("productIds") Collection<Long> productIds,
                                 Class<T> target);
}
