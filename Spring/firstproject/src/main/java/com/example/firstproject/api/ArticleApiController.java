package com.example.firstproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

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
}
