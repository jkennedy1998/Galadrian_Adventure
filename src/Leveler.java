/**
 * Created by jnebl on 1/6/2017.
 */
public class Leveler {
    public static int health, maxHealth;
    public static double attackMultiplier, accuracyMultiplier, defensiveMultiplier, speedMultiplier;
    public static int healthLevel(){
        health = 0;
        health += 10;
        return health;
    }
    public static int maxHealthLevel(){
        maxHealth = 0;
        maxHealth += 15;
        return maxHealth;
    }
    public static double attackMultiplierLevel(){
        attackMultiplier = 0;
        attackMultiplier += .1;
        return attackMultiplier;
    }
    public static double accuracyMultiplierLevel(){
        accuracyMultiplier = 0;
        accuracyMultiplier += .1;
        return accuracyMultiplier;
    }
    public static double defensiveMultiplierLevel(){
        defensiveMultiplier = 0;
        defensiveMultiplier += .1;
        return defensiveMultiplier;
    }
    public static double speedMultiplierLevel(){
        speedMultiplier = 0;
        speedMultiplier += 5;
        return speedMultiplier;
    }

}
