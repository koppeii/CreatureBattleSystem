public class Dog extends Creature {
    Dog() {
        // a way to allow subclasses to influence superclass fields

        this.health = 700;

        this.dmgRange = new float[]{80, 100};
            // why am i not allowed to initialize an array here? why like this (recommended by the ide), unlike in Creature?
        this.primaryActionWeights = new float[]{35, 55, 10};
        this.secondaryActionWeights = new float[]{40, 40, 20};
            // defend, dodge, nothing

        this.blockChance = 50;
        this.dodgeChance = 60;

        this.blockMultiplier = 0.5f;
    }

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
