package org.blog.blogplatformapi.controller;

import org.blog.blogplatformapi.model.Article;
import org.blog.blogplatformapi.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    //Constructor con inyeccion de dependencias
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //Endpoint para obtener todos los articulos
    @GetMapping
    public List<Article> getAllArticle() {
        return articleService.getAllArticles();
    }

    //Endpoint para obtener articulo por id
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //Enpoint para crear un nuevo articulo
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        Article createdArticle = articleService.createArticle(article);
        return ResponseEntity.ok(createdArticle);
    }

    //Enpoint para actualizar un articulo existente
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        try {
            Article updatedArticle = articleService.updateArticle(id, article);
            return ResponseEntity.ok(updatedArticle);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint para eliminar un articulo por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id){
        try {
            articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
