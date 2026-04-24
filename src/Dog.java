public class Dog extends Creature {
//        public float health = 700;
//
//        private float[] dmgRange = {80, 100};
//
        private float[] primaryActionWeights = {35, 55, 10};
//        private float[] secondaryActionWeights = {40, 40, 20};
//    // defend, dodge, nothing
//
//        private int blockChance = 50;
//        private int dodgeChance = 60;
//
//        private float blockMultiplier = 0.5f;

    public Dog() {
        super(700, new float[]{80, 100}, new float[]{35, 55, 10}, new float[]{40, 40, 20}, 50, 60, 0.5f);
    }

    // super() constructs first, and then the children construct second, thus its fields are instantiated later than the creature, and referencing
    // fields of a subclass while using super() will not work
        // putting in literals is claudes decision, although i was trying to find another method before asking


    @Override
    public float primaryAction(float power) {
        int actionInt = Rand.weightedInt(primaryActionWeights);

        switch (actionInt) {
            case 0: {
                return bite(power);
            }
            case 1: {
                return claw(power);
            }
            case 2: {
                return 0;
            }
        }

        return 0;
    }

    private float bite(float power) {
        float newPower = power * 0.7f;
        this.action = this.name + " bites for " + newPower + "!";

        return newPower;
    }

    private float claw(float power) {
        float newPower = power * 0.5f;
        this.action = this.name + " claws for " + newPower + "!";

        return newPower;
    }
}
