package com.example.firstproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ArticleApiController {
	
	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("/api/articles")
	public List<Article> index()
	{
		return articleRepository.findAll();
	}
	
	@GetMapping("/api/articles/{id}")
	public Article index(@PathVariable Long id){
		return articleRepository.findById(id).orElse(null);
		
	}
	
	@PostMapping("/api/articles")
	public Article create(@RequestBody ArticleForm dto)
	{
		Article article = dto.toEntity();
		return articleRepository.save(article);
	}
	
	@PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
            @RequestBody ArticleForm dto) 
    {
		Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());
        
        
        Article target = articleRepository.findById(id).orElse(null);

        if (target == null || id != article.getId()) {
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        target.patch(article);
        Article updated = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
				
    }
	
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        // 대상 삭제
        articleRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
