public class Werewolf extends Creature {
//     public float health = 800;
//
//     private float[] dmgRange = new float[]{120, 140};
//
    private float[] primaryActionWeights = new float[]{40, 10, 60};
//        this.secondaryActionWeights = new float[]{10, 10, 80};
//    // defend, dodge, nothing
//
//        this.blockChance = 80;
//        this.dodgeChance = 50;
//
//        this.blockMultiplier = 0.2f;

    Werewolf() {
       super(800, new float[]{120, 140}, new float[]{40,10, 60}, new float[]{10, 10, 80}, 80, 50, 0.2f);
    }

    @Override
    public float primaryAction(float power) {
        int actionInt = Rand.weightedInt(primaryActionWeights);

        switch (actionInt) {
            case 0: {
                return assail(power);
            }
            case 1: {
                return howl(power);
            }
            case 2: {
                return 0;
            }
        }

        return 0;
    }

    private float assail(float power) {
        float newPower = power * 0.9f;
        this.action = this.name + " assails, dealing " + newPower + "!";

        return newPower;
    }

    private float howl(float power) {
        float newPower = -power * 0.4f;
        this.action = this.name + " howls, healing for " + -newPower + "!";

        return newPower;
    }
}
