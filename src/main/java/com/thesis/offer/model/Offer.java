package com.thesis.offer.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String order;

    @BatchSize(size = 10)
    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY)
    @Builder.Default
    private List<OfferProduct> products = new ArrayList<>();
}
