package chapter2.pro4;

public class Main {
    public static void main(String[] args) {

        CartForSongs cartForSongs = new CartForSongs();

        Song song1 = new Song();
        song1.setMode(new OnSale());

        Song song2 = new Song();
        song2.setMode(new TodayEvent());


        cartForSongs.add(song1);
        cartForSongs.add(song2);

        System.out.println(cartForSongs.calculateTotalPrice());

    }
}
