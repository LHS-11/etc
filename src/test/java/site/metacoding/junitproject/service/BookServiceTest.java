package site.metacoding.junitproject.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import site.metacoding.junitproject.domain.BookRepository;
import site.metacoding.junitproject.util.MailSender;
import site.metacoding.junitproject.util.MailSenderStub;
import site.metacoding.junitproject.web.dto.BookRespDto;
import site.metacoding.junitproject.web.dto.BookSaveReqDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock // mockito 환경에다 넣어둠 -> 익명 클래스
    private BookRepository bookRepository;

    @Mock
    private MailSender mailSender;

    //문제점 -> 서비스만 테스트하고 싶은데, 레포지토리 레이어가 함께 테스트가 된다는 점
    @Test
    public void 책등록하기_test(){
        //given
        BookSaveReqDto dto = new BookSaveReqDto();
        dto.setTitle("junit강의");
        dto.setAuthor("메타코딩");

        //stub (가설)
        when(bookRepository.save(ArgumentMatchers.any())).thenReturn(dto.toEntity());
        when(mailSender.send()).thenReturn(true);
        // 가짜로 repository 만들기!!

        //when
        BookRespDto bookRespDto = bookService.책등록하기(dto);

        //then
//        assertEquals(dto.getTitle(), bookRespDto.getTitle());
//        assertEquals(dto.getAuthor(), bookRespDto.getAuthor());
        Assertions.assertThat(dto.getTitle()).isEqualTo(bookRespDto.getTitle());
        Assertions.assertThat(dto.getAuthor()).isEqualTo(bookRespDto.getAuthor());
    }
}
