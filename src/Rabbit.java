public class Rabbit extends Creature{
    Rabbit() {
        this.health = 500;

        this.dmgRange = new float[]{40, 80};
        this.secondaryActionWeights = new float[]{20, 70, 10};
        // defend, dodge, nothing

        this.missChance = 20;
        this.blockChance = 50;
        this.dodgeChance = 80;

        this.blockMultiplier = 0.4f;
    }
}
