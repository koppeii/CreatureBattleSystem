public class Rabbit extends Creature{
//   public float health = 500;
//
//   private float[] dmgRange = new float[]{60, 80};

   private float[] primaryActionWeights = new float[]{75, 20, 5};
//   private float[] secondaryActionWeights = new float[]{10, 90, 5};
//    // defend, dodge, nothing
//
//    private int blockChance = 20;
//    private int dodgeChance = 80;
//
//    private float blockMultiplier = 0.4f;

    Rabbit() {
        super(500, new float[]{60, 80}, new float[]{75, 20, 5}, new float[]{10, 90, 5}, 20, 80, 0.4f);
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
        float newPower = power * 0.4f;
        this.action = this.name + " pounces, dealing " + newPower + "!";

        return newPower;
    }

    private float nibble(float power) {
        float newPower = power * 0.5f;
        this.action = this.name + " nibbles for " + newPower + "!";

        return newPower;
    }
}
