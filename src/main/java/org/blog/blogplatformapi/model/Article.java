package org.blog.blogplatformapi.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;

import java.time.LocalDateTime;

//@Entity: Marca la clase como una entidad que sera administrada por JPA(Hibernate)
//@Table: Define la tabla en la base de datos como "articles"
@Entity
@Table(name = "articles")
public class Article {

    // Las anotaciones @Id y @GeneratedValue define id como la clave primaria y genera valores de forma automatica
    // @Column Especifica las caracteristicas de las columnas en la base de datos, su longitud, definicion y si son obligatorias
    // LocalDateTime se utilzar para manejar fecha y hora de publicacion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(length = 255)
    private String tags;

    @Column(nullable = false)
    private LocalDateTime publishedDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }
}
