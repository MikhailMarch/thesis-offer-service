package com.thesis.offer.repository;

import com.thesis.offer.model.CustomerProductLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProductLikeRepository extends JpaRepository<CustomerProductLike, Long> {
}
