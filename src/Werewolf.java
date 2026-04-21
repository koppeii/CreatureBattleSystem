public class Werewolf extends Creature {
    Werewolf() {
        this.health = 800;

        this.dmgRange = new float[]{80, 120};

        this.primaryActionWeights = new float[]{30, 5, 65};
        this.secondaryActionWeights = new float[]{10, 10, 80};
        // defend, dodge, nothing

        this.blockChance = 50;
        this.dodgeChance = 50;

        this.blockMultiplier = 0.2f;
    }

    @Override
    public float primaryAction(float power) {
        int actionInt = Rand.weightedInt(primaryActionWeights);

        switch (actionInt) {
            case 0: {
                return pounce(power);
            }
            case 1: {
                return nibble(power);
            }
            case 2: {
                return 0;
            }
        }

        return 0;
    }

    private float pounce(float power) {
        float newPower = power * 0.3f;
        this.action = this.name + " pounces, dealing " + newPower + "!";

        return newPower;
    }

    private float howl(float power) {
        float newPower = power * 0.3f;
        this.action = this.name + " howls, healing for " + newPower + "!";

        return newPower;
    }
}
