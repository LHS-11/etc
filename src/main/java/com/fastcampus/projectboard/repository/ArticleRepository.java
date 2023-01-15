package com.fastcampus.projectboard.repository;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource
// @Repository 굳이 안붙여도 됨. JpaRepository 상위클래스에서 이미 어노테이션이 붙어 있음
public interface ArticleRepository extends
        JpaRepository<Article, Long >,
        QuerydslPredicateExecutor<Article>, // Article 안에 있는 모든 필드에 대한 기본 검사를 추가해줌
        QuerydslBinderCustomizer<QArticle>
{
    Page<Article> findByTitle(String title, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true);
        bindings.including(root.title,root.content ,root.hashtag, root.createdAt, root.createdBy);
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);// like '%${}%'
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);// like '%${}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);// like '%${}%'
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);// like '%${}%'
//        bindings.bind(root.title).first(StringExpression::likeIgnoreCase); // like '' -> 사용자가 % 를 추가해줘야함
    }
}
