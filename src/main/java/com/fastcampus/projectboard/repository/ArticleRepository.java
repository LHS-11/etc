package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// @Repository 굳이 안붙여도 됨. JpaRepository 상위클래스에서 이미 어노테이션이 붙어 있음
public interface ArticleRepository extends JpaRepository<Article, Long > {

}
