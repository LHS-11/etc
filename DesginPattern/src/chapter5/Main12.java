package chapter5;

public class Main12 {

    public static void main(String[] args) {
        Robot atom = new Atom("아톰");

        atom.setAttackStrategy(new AttackLogic2());
        atom.setMoveStrategy(new MoveLogic2());

        atom.move();
        atom.attack();
    }
}
