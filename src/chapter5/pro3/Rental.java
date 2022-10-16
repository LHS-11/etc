package chapter5.pro3;

public class Rental {

    private Member member;

    private Book book;

    private DiscountMode discountMode;

    private int n; // 수량

    public Rental(Member member, Book book,int n){
        this.member = member;
        this.book = book;
        this.n = n;
    }

    public void setDiscountMode(DiscountMode discountMode){
        this.discountMode = discountMode;
        member.addAccPrice(discountMode.calcPrice(this.book.getPrice(),this.n));
    }

    public int getPrice(){
        return discountMode.calcPrice(book.getPrice(), n);
    }

}
