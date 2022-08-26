package site.metacoding.junitproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.metacoding.junitproject.domain.Book;
import site.metacoding.junitproject.domain.BookRepository;
import site.metacoding.junitproject.util.MailSender;
import site.metacoding.junitproject.web.dto.BookRespDto;
import site.metacoding.junitproject.web.dto.BookSaveReqDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor // final이 붙은 필드가 있을 때, 주입을 해줌 (Di)
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final MailSender mailSender;
    // 1. 책 등록
    @Transactional(rollbackFor = RuntimeException.class) // RuntimeException이 발생하면 롤백을 하겠다
    public BookRespDto 책등록하기(BookSaveReqDto dto){
        Book bookPS = bookRepository.save(dto.toEntity());
        if(bookPS!=null){
            if(!mailSender.send()) throw new RuntimeException("메일이 전송되지 않았습니다.");
        }
        // 이대로 DB에 save 된걸 가져오면 영속화된 데이터이기 때문에 이 값을 못나나게 막아줘야 한다.
        // 안그러면 다른 변수가 생겨서 바뀔때 값이 이상해 질 수 있음, 그래서 BookRespDto로 변환
        return bookPS.toDto(); // static으로 만들면 new 객체 생성 안해도 됨
    }

    // 2. 책 목록보기
    public List<BookRespDto> 책목록보기(){
        return bookRepository.findAll().stream()
//                .map((bookPS)-> bookPS.toDto())
                .map(Book::toDto) // 메소드 참조
                .collect(Collectors.toList());
    }
    // 3. 책 한건보기
    public BookRespDto 책한건보기(Long id){
        Optional<Book> bookOP = bookRepository.findById(id);
        if(bookOP.isPresent()){
            Book bookPS = bookOP.get();
            return bookPS.toDto();
        }else{
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
        }
    }
    // 4. 책 삭제
    @Transactional(rollbackFor = RuntimeException.class)
    public void 책삭제하기(Long id){
        bookRepository.deleteById(id);
    }
    // 5. 책 수정
    @Transactional(rollbackFor = RuntimeException.class) // controller 쪽에서 return 해줄 필요가 없음
    public BookRespDto 책수정하기(Long id,BookSaveReqDto dto){
        Optional<Book> bookOP = bookRepository.findById(id);
        if(bookOP.isPresent()){
            Book bookPS = bookOP.get();
            bookPS.update(dto.getTitle(),dto.getAuthor());
            return bookPS.toDto();
        }else{
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다.");
        }
    } // 영속화된 context 내용을 변경하기만 하면 메서드 종료시에 더티체킹(flush)으로 update 됨

}
