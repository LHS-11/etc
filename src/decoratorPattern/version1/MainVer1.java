package decoratorPattern.version1;

import javax.swing.*;

public class MainVer1 {

    public static void main(String[] args) {
        Strings strings = new Strings();

        strings.add("Hello");
        strings.add("My Name is HwaSup");
        strings.add("I'm student");

        BoxDecorator boxDecorator1 = new BoxDecorator(new SideDecorator(new LineNumberDecorator(strings),'*'));
        SideDecorator sideDecorator = new SideDecorator(new BoxDecorator(strings),'#');
        boxDecorator1.print();

        System.out.println();

        sideDecorator.print();
    }
}
