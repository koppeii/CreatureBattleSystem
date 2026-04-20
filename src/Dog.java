public class Dog extends Creature {
    Dog() {
        // a way to allow subclasses to influence superclass fields

        this.health = 700;
        this.dmgRange = new float[]{500, 600};
            // why am i not allowed to initialize an array here? why do i have to do it like this (recommended by the ide)

        this.missChance = 20;
        this.blockChance = 10;
        this.dodgeChance = 60;

        this. blockMultiplier = 0.4f;



    }
}
