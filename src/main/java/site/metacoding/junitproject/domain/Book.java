package site.metacoding.junitproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import site.metacoding.junitproject.web.dto.BookRespDto;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@Getter
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키로 설정돼서 자동으로 1씩 증가
    @Id
    private Long id;

    @Column(length = 50,nullable = false)
    private String title;

    @Column(length = 20,nullable = false)
    private String author;

    @Builder
    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public void update(String title,String author){
        this.title = title;
        this.author = author;
    }

    public BookRespDto toDto(){
        return BookRespDto.builder()
                .id(id)
                .title(title)
                .author(author)
                .build();
    }
}
