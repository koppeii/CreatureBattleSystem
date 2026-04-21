public class Rabbit extends Creature{
    Rabbit() {
        this.health = 500;

        this.dmgRange = new float[]{40, 80};

        this.primaryActionWeights = new float[]{75, 20, 5};
        this.secondaryActionWeights = new float[]{10, 90, 5};
        // defend, dodge, nothing

        this.blockChance = 20;
        this.dodgeChance = 80;

        this.blockMultiplier = 0.4f;
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

    private float nibble(float power) {
        float newPower = power * 0.5f;
        this.action = this.name + " nibbles for " + newPower + "!";

        return newPower;
    }
}
