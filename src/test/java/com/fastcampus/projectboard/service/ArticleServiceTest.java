package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut; // sut : system under test -> 테스트 대상

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void searchTest() {
        //given
//        SearchParameters param = SearchParameters.of(SearchType.TITLE,"search keyword");

        //when
        Page<ArticleDto> articles= sut.searchArticles(SearchType.TITLE,"search keyword"); // 제목, 본문, id, 닉네임, 해시태그

        //then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void readArticleReturnArticleTest() {
        //given
//        SearchParameters param = SearchParameters.of(SearchType.TITLE,"search keyword");

        //when
        ArticleDto article= sut.searchArticle(1L); // 제목, 본문, id, 닉네임, 해시태그

        //then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void inputArticleReturnArticleTest() {
        //given
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "cp3", "title","content","hashtag");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        //when
        sut.saveArticle(dto);

        //then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void inputArticleReturnArticleUpdatingTest() {
        //given
        ArticleUpdateDto dto = ArticleUpdateDto.of("title","content","hashtag");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        //when
        sut.updateArticle(1L, dto);

        //then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void inputArticleReturnArticleRemovingTest() {
        //given
        ArticleUpdateDto dto = ArticleUpdateDto.of("title","content","hashtag");
        willDoNothing().given(articleRepository).delete(any(Article.class));

        //when
        sut.deleteArticle(1L);

        //then
        then(articleRepository).should().delete(any(Article.class));
    }
}