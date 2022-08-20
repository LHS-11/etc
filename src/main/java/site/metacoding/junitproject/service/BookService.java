package site.metacoding.junitproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.junitproject.domain.Book;
import site.metacoding.junitproject.domain.BookRepository;
import site.metacoding.junitproject.web.dto.BookRespDto;
import site.metacoding.junitproject.web.dto.BookSaveReqDto;

@RequiredArgsConstructor // final이 붙은 필드가 있을 때, 주입을 해줌 (Di)
@Service
public class BookService {

    private final BookRepository bookRepository;

    // 1. 책 등록
    @Transactional(rollbackFor = RuntimeException.class) // RuntimeException이 발생하면 롤백을 하겠다
    public BookRespDto 책등록하기(BookSaveReqDto dto){
        Book bookPS = bookRepository.save(dto.toEntity());
        // 이대로 DB에 save 된걸 가져오면 영속화된 데이터이기 때문에 이 값을 못나나게 막아줘야 한다.
        // 안그러면 다른 변수가 생겨서 바뀔때 값이 이상해 질 수 있음, 그래서 BookRespDto로 변환
        return new BookRespDto().toDto(bookPS); // static으로 만들면 new 객체 생성 안해도 됨
    }

    // 2. 책 목록보기

    // 3. 책 한건보기

    // 4. 책 삭제

    // 5. 책 수정
}
