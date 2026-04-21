public class BattleSystem {
    public void battle(Creature a, Creature b) {
        Creature temp;

        while (a.health > 0 && b.health > 0) {

            float attackPower = a.genAttackPower();
            float modAttackPower = a.primaryAction(attackPower);

            System.out.println(a.name + " " + b.name);

            b.secondaryAction(modAttackPower, a);

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
            temp = a;
            a = b;
            b = temp;
        }
    }
}
