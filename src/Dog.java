public class Dog extends Creature {

    public float[] dmgRange = {50, 100};

    @Override
    public float genAttackPower() {

        // 10% chance of missing
        if (Rand.randomInt(0, 10) < 1) {
            return 0;
        }

        // otherwise, do damage between 10-20
        float power = Rand.randomFloat(dmgRange[0], dmgRange[1]);
        return power;
    }
}
