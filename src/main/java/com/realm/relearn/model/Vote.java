package com.realm.relearn.model;

import com.realm.relearn.model.enumeration.VoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_vote", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "VoteType", nullable = false)
    private VoteType voteType;

    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_post", referencedColumnName = "id_post")
    private Post post;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;
}