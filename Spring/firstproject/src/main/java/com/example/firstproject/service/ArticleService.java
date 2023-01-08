package com.example.firstproject.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> index() {
		return articleRepository.findAll();
		 
	}

	public Article show(Long id) {
		// TODO Auto-generated method stub
		return articleRepository.findById(id).orElse(null);
	}

	public Article create(ArticleForm dto) {
		Article article = dto.toEntity();
		return articleRepository.save(article);
	}

	public Article update(Long id, ArticleForm dto) {

		Article article = dto.toEntity();
		log.info("id: {}, article : {} ",id,article.toString());
		
		Article target = articleRepository.findById(id).orElse(null);
		
		if(target == null || id != article.getId())
		{
			log.info("잘못된 요청! id:{}, article: {}",id, article.toString());
			return null;
		}
	
		target.patch(article);
		Article updated = articleRepository.save(target);
		return updated;
	}

	public Article delete(Long id) {

		 // 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);

        // 잘못된 요청 처리
        if (target == null) {
            return null;
        }

        // 대상 삭제
        articleRepository.delete(target);
		return target;
	}
	
	 @Transactional
	    public List<Article> createArticles(List<ArticleForm> dtos) {
	        // dto 묶음을 entity 묶음으로 변환
	        List<Article> articleList = dtos.stream()
	                .map(dto -> dto.toEntity())
	                .collect(Collectors.toList());

	        // entity 묶음을 DB로 저장
	        articleList.stream()
	                .forEach(article -> articleRepository.save(article));

	        // 강제 예외 발생
	        articleRepository.findById(-1L).orElseThrow(
	                () -> new IllegalArgumentException("결제 실패!")
	        );

	        // 결과값 반환
	        return articleList;
	    }
}
