package chapter5.pro3;

public class Main15 {
    public static void main(String[] args) {

        Book book = new Book("star", 1980, 1000);
        Member member = new Member("paul");

        Rental rental = new Rental(member, book, 5);

        rental.setDiscountMode(new BookMode());

        System.out.println(member.getAccPrice());

        System.out.println(rental.getPrice());

    }
}
