public class types {
    public static final int NORMAL = 0;
    public static final int FIRE = 1;
    public static final int WATER = 2;
    public static final int ELECTRIC = 3;
    public static final int GRASS = 4;
    public static final int ICE = 5;
    public static final int FIGHTING = 6;
    public static final int POISON = 7;
    public static final int GROUND = 8;
    public static final int FLYING = 9;
    public static final int PSYCHIC = 10;
    public static final int BUG = 11;
    public static final int ROCK = 12;
    public static final int GHOST = 13;
    public static final int DRAGON = 14;

    // If a type is normally effective, 1, super effective is 2, not very effective is 0.5, and immune
    // is 0
    public static final double[][] TYPE_EFFECTIVNESS = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5, 0, 1}, // Normal
            {1, .5, .5, 1, 2, 2, 1, 1, 1, 1, 1, 2, .5, 1, .5}, // Fire
            {1, 2, .5, 1, .5, 1, 1, 1, 2, 1, 1, 1, 2, 1, .5}, // Water
            {1, 1, 2, .5, .5, 1, 1, 1, 0, 2, 1, 1, 1, 1, .5}, // Electric
            {1, .5, 2, 1, .5, 1, 1, .5, 2, .5, 1, .5, 2, 1, .5}, // Grass
            {1, 1, .5, 1, 2, .5, 1, 1, 1, 2, 1, 1, 1, 1, 2}, // Ice
            {2, 1, 1, 1, 1, 2, 1, .5, 1, .5, .5, .5, 2, 0, 1}, // Fighting
            {1, 1, 1, 1, 2, 1, 1, .5, .5, 1, 1, 2, .5, .5, 1}, // Poison
            {1, 2, 1, 2, .5, 1, 1, 2, 1, 0, 1, .5, 2, 1, 1}, // Ground
            {1, 1, 1, .5, 2, 1, 2, 1, 1, 1, 1, 2, .5, 1, 1}, // Flying
            {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, .5, 1, 1, 1, 1}, // Psychic
            {1, .5, 1, 1, 2, 1, .5, 2, 1, .5, 2, 1, 1, .5, 1}, // Bug
            {1, 2, 1, 1, 1, 2, .5, 1, .5, 2, 1, 2, 1, 1, 1}, // Rock
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1}, // Ghost
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}, // Dragon
    };
}
