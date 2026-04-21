public class Dog extends Creature {
    Dog() {
        // a way to allow subclasses to influence superclass fields

        this.health = 700;

        this.dmgRange = new float[]{50, 100};
            // why am i not allowed to initialize an array here? why like this (recommended by the ide), unlike in Creature?
        this.secondaryActionWeights = new float[]{45, 45, 10};
            // defend, dodge, nothing

        this.missChance = 20;
        this.blockChance = 50;
        this.dodgeChance = 60;

        this.blockMultiplier = 0.6f;
    }

    @Override
    public void primaryAction(float power) {
        int action = Rand.weightedInt(primaryActionWeights);

        switch (action) {
            case 0: {
//                attack(power);
//                break;
            }
        }
    }
}
