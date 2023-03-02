package guru.springframework.msscbeerservice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(length = 36, updatable = false, nullable = false, columnDefinition = "varchar")
    private UUID id;
    @Version
    private Long version;
    private String beerName;
    private String beerStyle;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
    private Integer minOnHand;
    private Integer quantityToBrew;
}
