public class Creature {
    public String name;
    public String action;

    public float health = 1000;
    private float[] dmgRange = {50, 100};

    private int missChance = 10;
    private int blockChance = 20;
    private int dodgeChance = 50;

    private float blockMultiplyer = 0.5f;

    // Returns the damage done by the Creature
    public float genAttackPower() {
        if (Rand.randomInt(0, 100) < missChance) {
            return 0;
        }

        float power = Rand.randomFloat(dmgRange[0], dmgRange[1]);
        return power;
    }

    public void attack(float power) {
        if (power <= 0) {
            action = name + " missed!";
            return;
        }

        action = name + " attacked with power " + power + "!";
    }

    public void defend(float incomingPower) {

        // 20% chance of reducing 50% damage taken
        if (Rand.randomInt(0, 100) < blockChance) {
            incomingPower *= blockMultiplyer;
            action = name + " defended and reduced damage taken to " + incomingPower;
        }
        else
            action = name + " did not defend.";

        takeDamage(incomingPower);
    }

    public void dodge(float incomingPower) {
        if (Rand.randomInt(0, 100) < dodgeChance)
            action = name + " dodged!";
        else {
            action = name + " attempted to dodge, but failed!";
            takeDamage(incomingPower);
        }
    }

    public void takeDamage(float damage) {
        health -= damage;
    }

    public String readAction() {
        return action;
    }

    @Override
    public String toString() {
        return getClass() + "{name: " + name + ", health: " + health + "}";
    }
}
