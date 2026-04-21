public class Main {
    public static void main(String[] args) {

        // set up the creatures
        Creature a = new Rabbit();
        Creature b = new Dog();
        a.name = "Rabbit";
        b.name = "Dog";

        // set up the battle
        BattleSystem battleSystem = new BattleSystem();

        // run the battle
        battleSystem.battle(a, b);
    }
}
