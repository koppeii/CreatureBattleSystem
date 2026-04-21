public class Main {
    public static void main(String[] args) {

        // set up the creatures


        Creature a = Rand.randomCreature();
        Creature b = Rand.randomCreature();
        a.name = "Grimm";
        b.name = "Lewis";

        // set up the battle
        BattleSystem battleSystem = new BattleSystem();

        // run the battle
        battleSystem.battle(a, b);
    }
}
