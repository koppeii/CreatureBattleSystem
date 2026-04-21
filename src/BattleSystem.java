public class BattleSystem {
    public void battle(Creature a, Creature b) {
        while (a.health > 0 && b.health > 0) {
            float attackPower = a.genAttackPower();
            a.primaryAction(attackPower);

            b.secondaryAction(attackPower);


            System.out.println(a.readAction());
            System.out.println(b.readAction());

            System.out.println(a);
            System.out.println(b);
            System.out.println();

            if (a.health <= 0) {
                System.out.println(b.name + " has won!");
                return;
            }
            else if (b.health <= 0) {
                System.out.println(a.name + " has won!");
                return;
            }

            // swap turns
            Creature temp = a;
            a = b;
            b = temp;
        }
    }
}
