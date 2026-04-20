public class Rabbit extends Creature{
    Rabbit() {
        this.health = 500;
        this.dmgRange = new float[]{50, 100};

        this.missChance = 20;
        this.blockChance = 10;
        this.dodgeChance = 60;

        this.blockMultiplier = 0.4f;
    }
}
