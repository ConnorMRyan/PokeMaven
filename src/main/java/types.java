public class types {
    // For pokemon without a secondary type.
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
    public static final int NO_TYPE = 15;

    // If a type is normally effective, 1, super effective is 2, not very effective is 0.5, and immune
    // is 0
    public static final double[][] TYPE_EFFECTIVNESS = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, .5, 0, 1, 1}, // Normal
            {1, .5, .5, 1, 2, 2, 1, 1, 1, 1, 1, 2, .5, 1, .5, 1}, // Fire
            {1, 2, .5, 1, .5, 1, 1, 1, 2, 1, 1, 1, 2, 1, .5, 1}, // Water
            {1, 1, 2, .5, .5, 1, 1, 1, 0, 2, 1, 1, 1, 1, .5, 1}, // Electric
            {1, .5, 2, 1, .5, 1, 1, .5, 2, .5, 1, .5, 2, 1, .5, 1}, // Grass
            {1, 1, .5, 1, 2, .5, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1}, // Ice
            {2, 1, 1, 1, 1, 2, 1, .5, 1, .5, .5, .5, 2, 0, 1, 1}, // Fighting
            {1, 1, 1, 1, 2, 1, 1, .5, .5, 1, 1, 2, .5, .5, 1, 1}, // Poison
            {1, 2, 1, 2, .5, 1, 1, 2, 1, 0, 1, .5, 2, 1, 1, 1}, // Ground
            {1, 1, 1, .5, 2, 1, 2, 1, 1, 1, 1, 2, .5, 1, 1, 1}, // Flying
            {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, .5, 1, 1, 1, 1, 1}, // Psychic
            {1, .5, 1, 1, 2, 1, .5, 2, 1, .5, 2, 1, 1, .5, 1, 1}, // Bug
            {1, 2, 1, 1, 1, 2, .5, 1, .5, 2, 1, 2, 1, 1, 1, 1}, // Rock
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 1}, // Ghost
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1}, // Dragon
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1} // No type, shouldn't be needed...
    };

    static int getType(String type) {
        switch (type.toUpperCase()) {
            case ("NORMAL"):
                return 0;
            case ("FIRE"):
                return 1;
            case ("WATER"):
                return 2;
            case ("ELECTRIC"):
                return 3;
            case ("GRASS"):
                return 4;
            case ("ICE"):
                return 5;
            case ("FIGHTING"):
                return 6;
            case ("POISON"):
                return 7;
            case ("GROUND"):
                return 8;
            case ("FLYING"):
                return 9;
            case ("PSYCHIC"):
                return 10;
            case ("BUG"):
                return 11;
            case ("ROCK"):
                return 12;
            case ("GHOST"):
                return 13;
            case ("DRAGON"):
                return 14;
            default:
                return 15;
        }
    }
}
