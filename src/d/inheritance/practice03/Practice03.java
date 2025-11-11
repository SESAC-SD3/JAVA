package d.inheritance.practice03;

abstract class GameCharacter {
    protected String name;
    protected int attackPower;

    public GameCharacter(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public final void attack() {
        prepare();
        executeAttack();
        finish();
    }

    void prepare() {
        System.out.println("공격 준비!");
    }

    abstract void executeAttack ();

    void finish() {
        System.out.println("공격 완료!");
    }
}

class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name, 50);
    }

    @Override
    void executeAttack() {
        System.out.println("검으로 베기! " + attackPower);
    }
}
class Mage extends GameCharacter {
    public Mage(String name) {
        super(name, 80);
    }

    @Override
    void executeAttack() {
        System.out.println("마법 공격! " + attackPower);
    }
}

public class Practice03 {
    public static void main(String[] args) {
        GameCharacter warrior = new Warrior("전사");
        warrior.attack();

        System.out.println();

        GameCharacter mage = new Mage("마법사");
        mage.attack();
    }
}
