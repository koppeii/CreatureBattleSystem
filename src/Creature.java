public class Creature {
    public String name;
    public String action;

    protected float health = 1000;

    protected float[] dmgRange = {50, 100};
    protected float[] primaryActionWeights = {100};
    protected float[] secondaryActionWeights = {40, 40, 20};

    protected int missChance = 10;
    protected int blockChance = 50;
    protected int dodgeChance = 50;

    protected float blockMultiplier = 0.5f;

    // protected is a way to allow subclasses to influence superclass fields


    // Returns the damage done by the Creature
    public float genAttackPower() {
        if (Rand.randomInt(0, 100) < missChance) {
            return 0;
        }

        float power = Rand.randomFloat(dmgRange[0], dmgRange[1]);
        return power;
    }



    public void primaryAction(float power) {
        int action = Rand.weightedInt(primaryActionWeights);

        switch (action) {
            case 0: {
                attack(power);
                break;
            }
        }
    }

    private void attack(float power) {
        if (power <= 0) {
            action = name + " missed!";
            return;
        }

        action = name + " attacked with power " + power + "!";
    }

    public void secondaryAction(float incomingPower) {
        int action = Rand.weightedInt(secondaryActionWeights);

        switch (action) {
            case 0: {
                defend(incomingPower);
                break;
            }
            case 1: {
                dodge(incomingPower);
                break;
            }
            case 2: {
                doNothing(incomingPower);
                break;
            }
        }
    }

    private void defend(float incomingPower) {

        // 20% chance of reducing 50% damage taken
        if (Rand.randomInt(0, 100) < blockChance) {
            incomingPower *= blockMultiplier;
            action = name + " defended and reduced damage taken to " + incomingPower;
        }
        else
            action = name + " did not defend.";

        takeDamage(incomingPower);
    }

    private void dodge(float incomingPower) {
        if (Rand.randomInt(0, 100) < dodgeChance)
            action = name + " dodged!";
        else {
            action = name + " attempted to dodge, but failed!";
            takeDamage(incomingPower);
        }
    }

    private void doNothing(float incomingPower) {
        action = name + " stays still...";

        takeDamage(incomingPower);
    }

    private void takeDamage(float damage) {
        health -= damage;

        if (health <= 0)
            health = 0;
    }

    public String readAction() {
        return action;
    }

    @Override
    public String toString() {
        return getClass() + "{name: " + name + ", health: " + health + "}";
    }
}