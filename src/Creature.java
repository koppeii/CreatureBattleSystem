public class Creature {
    public String name;
    public String action;

    protected float health = 1000;

    protected float[] dmgRange = {50, 100};
    protected float[] primaryActionWeights = {90, 10};
    protected float[] secondaryActionWeights = {40, 40, 20};

    protected int blockChance = 50;
    protected int dodgeChance = 50;

    protected float blockMultiplier = 0.5f;

    // protected is a way to allow subclasses to influence superclass fields/methods


    // Returns the damage done by the Creature
    public float genAttackPower() {
        float power = Rand.randomFloat(dmgRange[0], dmgRange[1]);
        return power;
    }

    public float primaryAction(float power) {
        int actionInt = Rand.weightedInt(primaryActionWeights);

        switch (actionInt) {
            case 0: {
                return attack(power);
            }
            case 1: {
                return 0;
            }

        }

        return 0;
    }

    private float attack(float power) {
        action = name + " attacked with power " + power + "!";
        return power * 1;
    }

    public void secondaryAction(float incomingPower, Creature attacker) {
        int actionInt = Rand.weightedInt(secondaryActionWeights);

        if (incomingPower == 0)
            attacker.action = attacker.name + " missed!";
        else if (incomingPower < 0) {
            attacker.health = attacker.health + (-incomingPower);
            incomingPower = 0;
        }

        switch (actionInt) {
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
            action = name + " defended and reduced damage taken to " + incomingPower + "!";
        }
        else
            action = name + " failed to defend!";

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