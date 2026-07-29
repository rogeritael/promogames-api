package br.com.promogames.promogames.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "store_url")
    private String storeUrl;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "platforms", columnDefinition = "text[]", nullable = false)
    private String[] platforms;

    @CreationTimestamp //notação do hibernate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
