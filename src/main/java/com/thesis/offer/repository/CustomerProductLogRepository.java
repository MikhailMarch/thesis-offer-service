package com.thesis.offer.repository;

import com.thesis.offer.model.CustomerProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProductLogRepository extends JpaRepository<CustomerProductLog, Long> {
}
