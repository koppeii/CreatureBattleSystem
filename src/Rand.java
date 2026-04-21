import java.util.Random;

public class Rand
{
    // fields
    private static Random rand;

    // internal helper methods
    private static void Initialize()
    {
        if (rand == null)
        {
            rand = new Random();
        }
    }

    // methods
    public static float random()
    {
        Initialize();

        return rand.nextFloat();
    }

    public static int randomInt(int minInclusive, int maxExclusive)
    {
        Initialize();

        if (maxExclusive - minInclusive <= 0)
        {
            System.out.println("Warning: maxExclusive must be greater than minInclusive in Rand.randomInt(min, max).");
            return 0;
        }

        return rand.nextInt(maxExclusive - minInclusive) + minInclusive;
    }

    public static float randomFloat(float minInclusive, float maxExclusive)
    {
        Initialize();

        if (maxExclusive - minInclusive <= 0)
        {
            System.out.println("Warning: maxExclusive must be greater than minInclusive in Rand.randomFloat(min, max).");
            return 0;
        }

        return rand.nextFloat(maxExclusive - minInclusive) + minInclusive;
    }

    public static int weightedInt(float[] weights) {
        float summedWeights = 0;
        for (float weight : weights)
            summedWeights += weight;

        float randomValue = summedWeights * randomFloat(0, 1);
        float cumulativeWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            cumulativeWeight += weights[i];

            if (randomValue < cumulativeWeight)
                return i;
        }
        return 0;
    }

    public static Creature randomCreature() {
        int randInt = randomInt(1, 4);

        switch (randInt) {
            case 1:
                return new Dog();
            case 2:
                return new Rabbit();
            case 3:
                return new Werewolf();
        }

        return null;
    }
}
