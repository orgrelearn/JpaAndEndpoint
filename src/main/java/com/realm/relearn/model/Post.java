package com.realm.relearn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.realm.relearn.model.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post implements Serializable {

    public Post(String title,String description ,String content, LocalDate created, LocalDate modified, User user, Category category) {
        this.title = title;
        this.description= description;
        this.content = content;
        this.created = created;
        this.modified = modified;
        this.user = user;
        this.category = category;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, updatable = false)
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String title;

    @Nullable
    private String url;

    @NotBlank
    @Lob
    @Column(name = "content", columnDefinition = "text" , nullable = false)
    private String content;

    @NotBlank
    @Lob
    @Column(name = "description", columnDefinition = "text" , nullable = false)
    private String description;

    //private Instant createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name = "created", nullable = false , columnDefinition = "DATE")
    @NotBlank
    private LocalDate created;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Column(name = "modified" , columnDefinition = "DATE")
    private LocalDate modified;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_user",
            nullable = false,
            referencedColumnName = "id_user",
            foreignKey = @ForeignKey(
                    name = "user_post_fk"
            ))
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;
}