package com.thesis.offer.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(
        uniqueConstraints = {@UniqueConstraint(columnNames = {"product", "userId"})}
)
public class CustomerProductLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OfferProduct product;

    @CreationTimestamp
    private Timestamp dateCreated;
}
