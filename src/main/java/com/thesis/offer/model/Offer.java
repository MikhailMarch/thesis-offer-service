package com.thesis.offer.model;


import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer ordering;

    @BatchSize(size = 10)
    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY)
    @OrderBy("ordering")
    @Builder.Default
    private List<OfferProduct> products = new ArrayList<>();
}
