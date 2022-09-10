package com.realm.relearn.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty
    private String text;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_post", referencedColumnName = "id_post")
    private Post post;

    @Column(name = "createdDateTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDateTime;

    @NotEmpty
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
}