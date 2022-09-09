Integer => byte, short, int, long
size =>       1,     2,   4,    8

리터럴의 경우 뒤에 l 을 붙여여함
ex) long size=10000000l;

작은 값을 큰 값에 담을 수는 있어도 (implicit 유형)
큰 값을 작은 값에 담을 수는 없음 (만약 하고 싶으면 cast 함수를 통한 형변환 필요)

형변환 => cast 함수
ex) int size1;
    long size = long size=10000000l;
    int size1 = (int) size;

앞에 0을 붙이면 8진수 , 0x를 붙이면 16진수
ex) int eight=010 => eight=8, int sixteen=0x8 => sixteen=16


Floating Point (부동 소수점)
double, float

float => 부동 소수 리터럴 (정수 뒤에 f를 붙여야함)
ex) float f= 34.5f

부동 소수 데이터 유형은 정확하지 않음
=> 부동 소숫값이 표현되는 방식 때문에
해결책 : BigDecimal 사용

BigDecimal 객체는 한 번 만든 이상 값을 변경할 수 없음 => 새 변수만 생성해야함
BigDecimal 객체를 계산할 때는 double x , string o

ex)
BigDecimal number = new BigDecimal("11.5")
int i=5;
number.add(new BigDecimal(i)) => 16.5

ex)
int i=10;
int j=15;
j>15 && i++>5 =>  && 단축 회로 연산자 (수식 자체가 거짓이면 평가 자체를 하지 않음)
=> i,j는 변하지 않음

j>15 && i++>5 => & 연산자 하나가 거짓임에도 다 실행
=> i=11,j=15

