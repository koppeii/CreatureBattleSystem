public class Creature {
    public float health = 1000;
    public String name;
    public float[] dmgRange = {50, 100}  ;

    public String action;


    // Returns the damage done by the Creature
    public float genAttackPower() {

        // 20% chance of missing
        if (Rand.randomInt(0, 10) < 2) {
            return 0;
        }

        // otherwise, do damage between 10-20
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
        if (Rand.randomInt(0, 10) < 2) {
            incomingPower *= 0.5f;
            action = name + " defended and reduced damage taken to " + incomingPower;
        }
        else
            action = name + " did not defend.";

        takeDamage(incomingPower);
    }

    public void dodge(float incomingPower) {
        if (Rand.randomInt(0, 10) < 5)
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
