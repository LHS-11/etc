# 4주차 목표
1. 클래스(객체)를 분리하는 연습
2. 리팩터링

## 부족했던 점과 고려 해야할 점

1.  기능 목록 재검토 ( 3주차에 너무 세세하게 기능 목록을 작성했었다.  →  출력 기능, 입력 기능 , 필요한 객체 기능 나눠서 크게 보자! )
2. 필드, 인스턴스 변수 줄이기 ( 중복이거나 불필요한 필드 최대한 줄이기!)
3. **클래스와 메서드 분리 하기** ( 10라인을 넘어가지 않도록 구현하기! + 객체지향적으로 더 생각하자! + 인자 최대 3개까지만!)
4. **객체는 객체스럽게 사용하기** ( getter 메서드 사용하는 대신 **객체에 메시지를 보내자**! )
5. final 키워드 사용해서 값의 변경 막기 ( 값이 변하지 않을 경우에 final 을 고려하자! )
6. 단위 테스트 충실히 이행 ( 기능 구현할 때마다 단위 테스트를 진행하자! + 예외사항 테스트)
7. 상수명 작명 ( 상수명에 숫자는 최대한 제외 해보기, 객체에 값이 묶여서 숫자가 변경되면 상수명도 바꿔야 할 수 있다! )
8. 상수나 예외처리 메서드가 중복이 있을 때 클래스를 하나 만들어서 거기에 정의하고 그 클래스에서만 사용한다면 그 클래스 내에서 정의하기!
9. private 함수를 테스트 하고 싶다면 클래스(객체) 분리를 고려하기 ( 3주차때는 private 함수를 포함하고 있는 public 함수에서 테스트를 진행하였다, 가독성 이상의 역할을 할 때 클래스 분리를 고려해보자! )


## 기능 구현 목록

### 입력 기능

- [x]  다리의 길이 입력 받기
- [x]  이동할 칸 입력 받기
- [x]  재시도 여부 입력 받기

### 출력 기능

- [x]  현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
- [x]  게임의 최종결과 출력
   - [x]  끝까지 이동한 다리의 상태 출력
   - [x]  게임 성공 여부 및 시도횟수 출력

### 예외사항

- [x]  입력 받은 다리의 길이 체크
   - [x]  다리의 길이가 숫자인지 체크
   - [x]  다리의 길이가 3~20사이의 숫자인지 체크
- [x]  입력 받은 이동할 칸 문자 체크
   - [x]  입력받은 이동할 칸 문자 U,D인지 체크
- [x]  입력 받은 재시도 여부 문자 체크
   - [x]  입력 받은 재시도 여부 문자가 R,Q인지 체크
- [x] 예외사항 발생시 Error 메시지 출력 후 다시 재입력 받기

### 다리 생성

- [x]  다리의 길이에 맞춰서 무작위 다리 생성
   - [x]  랜덤 숫자 생성
   - [x]  숫자가 1일 경우 U 표현 ( 위의 칸에 다리 연결 )
   - [x]  숫자가 0일 경우 D 표현 ( 아래 칸에 다리 연결 )

### 다리 비교

- [x]  이동한 곳에 다리 존재하는지 비교할 수 있다.
   - [x]  이동한 다리의 칸이 O,X인지 알 수 있다.
      - [x]  서로 문자가 같으면 O 반환
      - [x]  서로 문자가 다르면 X 반환
- [x] 다리 결과 중에 X 가 나온 것을 알 수 있다.
    - [x] 위 다리 결과 중에 X 가 나온 것을 알 수 있다.
    - [x] 아래 다리 결과 중에 X 가 나온 것을 알 수 있다.
- [x] 다리 끝까지 도달 했는지 알 수 있다.

### 다리 결과 정보

- [x]  사용자가 이동한 칸의 번호에 따라 결과 ( O,X ) 저장
  - [x] 위칸 다리 결과를 O,X 로 표현 할 수 있다.
  - [x] 아래칸 다리 결과를 O,X로 표현 할 수 있다.


### 움직임
- [x] 사용자가 해당 칸에 이동한다
  - [x] 위치 +1 할 수 있다.

### 다리 도달
- [x] 사용자가 다리의 길이를 끝까지 갔는지 확인할 수 있다.
  - [x] 사용자의 위치와 다리의 길이를 비교할 수 있다.

### 재시도

- [x]  입력 받은 문자가 R인지 Q인지 알 수 있다.
   - [x]  입력 받은 문자가 R인지 알 수 있다.
   - [x]  입력 받은 문자가 Q인지 알 수 있다.


### 시도 횟수 (계산)

- [x]  재시도를 할 때마다 시도 횟수 카운트
   - [x]  시도 횟수를 +1 할 수 있다.
   - [x]  사용자 위치 초기화 






### `IllegalArgumentException`, `IllegalStateException` 차이
   - **IllegalArgumentException**
      - 부정한 인수 또는 부적절한 인수를 메서드에 건네준 것을 나타내기 위해 발생

     ex) 길이가 5여야 하는데 길이가 그 이상인 인수를 건네 줬을 때

   - IllegalStateException
      - 부정 또는 부적절한 때에 메서드가 불려 간 것을 나타냄

     ex) 결과값이 없을 때 메서드가 호출