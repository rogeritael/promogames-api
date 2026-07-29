package br.com.promogames.promogames.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "original_price",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal originalPrice;

    @Column(
            name = "current_price",
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal currentPrice;

    @Column(name = "starts_at")
    private LocalDateTime startsAt;

    @Column(name = "ends_at")
    private LocalDateTime endsAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "game_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_offer_game")
    )
    private Game game;
}
