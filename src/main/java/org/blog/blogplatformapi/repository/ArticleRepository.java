package org.blog.blogplatformapi.repository;

import org.blog.blogplatformapi.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository proporciona los metodos CRUD predefinidos como save, findById, findAll y deleteById
//findByTagsContaining es un metodo personalizado que busca articulos que contengan cierto tag
public interface ArticleRepository extends JpaRepository<Article,Long> {
    List<Article> findByTagsContaining(String tag);

}
