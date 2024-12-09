package org.blog.blogplatformapi.service;

import org.blog.blogplatformapi.model.Article;
import org.blog.blogplatformapi.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    //Constructor para inyectar repositorio
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    //Obtener todos los articulos por Id
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    //Obtener un articulo por Id
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    //Crear un nuevo articulo
    public Article createArticle(Article article) {
        article.setPublishedDate(article.getPublishedDate() == null ?
                java.time.LocalDateTime.now() : article.getPublishedDate());
        return articleRepository.save(article);
    }

    //Update un articulo existente
    public Article updateArticle(Long id, Article updateArticle) {
        Article existingArticle = articleRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Articulo no encontrado con id: " + id));

        //Actualizar los campos del articulo
        existingArticle.setTitle(updateArticle.getTitle());
        existingArticle.setContent(updateArticle.getContent());
        existingArticle.setTags(updateArticle.getTags());
        existingArticle.setPublishedDate(updateArticle.getPublishedDate());

        return articleRepository.save(existingArticle);
    }

    //Delete un articulo por id
    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Articulo no encontrado con id: " + id);
        }
        articleRepository.deleteById(id);
    }
}
