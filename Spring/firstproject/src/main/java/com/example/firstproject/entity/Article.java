package com.example.firstproject.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Article {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	public Article(Long id, String title, String content)
	{
		this.id=id;
		this.title=title;
		this.content=content;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Article{"+
				"Id="+id+
				",title ='"+title+'\''+
				",content'"+content+'\''+
				'}';
	}
}
