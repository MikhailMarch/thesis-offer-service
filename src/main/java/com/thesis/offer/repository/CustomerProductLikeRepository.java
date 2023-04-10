package com.thesis.offer.repository;

import com.thesis.offer.model.CustomerProductLike;
import com.thesis.offer.model.view.ProductOfferView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProductLikeRepository extends JpaRepository<CustomerProductLike, Long> {

    @EntityGraph(attributePaths = "product.offer")
    Page<CustomerProductLike> findAllByUserIdOrderByDateCreated(@Param("userId") Long userId,
                                                                Pageable pageable);
}
