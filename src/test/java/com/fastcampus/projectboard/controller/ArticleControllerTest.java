package com.fastcampus.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class) // () 안에 controller 클래스를 넣으면 해당 컨트롤러만 작동함
class ArticleControllerTest {

    private final MockMvc mvc;

    // 생성자 주입에서 생성자가 하나 밖에 없으면 @Autowired 생략 가능, but Test 에서는 안됨
    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @Disabled("구현 중")
    @DisplayName("[view][Get] 게시글 리스트 (게시판) 페이지 - 정상 호출")
    @Test
    void test1() throws Exception {
        //given

        //when & then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExiste("articleComments"))
                .andExpect(model().attributeExists("articles")); // data 안쪽까지 validation 하는 것은 아니고 articles 라는 이름을 가진 모델이 있는지 확인 가능



    }

    @Disabled("구현 중")
    @DisplayName("[view][Get] 게시글 상세 페이지 - 정상 호출")
    @Test
    void test2() throws Exception {
        //given

        //when & then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("articleComments"))
                .andExpect(model().attributeExists("article")); // data 안쪽까지 validation 하는 것은 아니고 articles 라는 이름을 가진 모델이 있는지 확인 가능

    }

    @Disabled("구현 중")

    @DisplayName("[view][Get] 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    void test3() throws Exception {
        //given

        //when & then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("article/search")); // data 안쪽까지 validation 하는 것은 아니고 articles 라는 이름을 가진 모델이 있는지 확인 가능

    }
    @Disabled("구현 중")

    @DisplayName("[view][Get] 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    void test4() throws Exception {
        //given

        //when & then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("article/search-hashtag")); // data 안쪽까지 validation 하는 것은 아니고 articles 라는 이름을 가진 모델이 있는지 확인 가능

    }
}