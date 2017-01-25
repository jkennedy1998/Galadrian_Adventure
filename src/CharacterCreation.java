import javax.swing.*;

/**
 * Created by jnebl on 12/22/2016.
 */

public class CharacterCreation {
    public String attack1 = "";
    public String attack2 = "";
    public String attack3 = "";
    public String attack4 = "";
    private int health, maxHealth, speed, level, score, exp, expLim;
    private double attackMultiplier, accuracyMultiplier, defensiveMultiplier, speedMultiplier;
    private String race,role;
    private double attackMultiplierLocked, accuracyMultiplierLocked, defensiveMultiplierLocked, speedMultiplierLocked;
    public CharacterCreation(){
        health = 100;
        maxHealth = 100;
        speed = 60;
        level = 0;
        score = 100;
        exp = 0;
        expLim = 5;
        attackMultiplier = 1;
        accuracyMultiplier = 1;
        defensiveMultiplier = 1;
        speedMultiplier = 1;
    }

    public void race() {
        String[] buttons = {"Human", "Orc", "Dwarf", "Elf", "Halfling"};

        int choice = JOptionPane.showOptionDialog(null, "Which race would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String race = "";
        if (choice == 0) {//generic human. stats based on human
            this.race = "Human";
            setAttackMultiplier(0);
            setAccuracyMultiplier(0);
            setSpeedMultiplier(0);
            setDefensiveMultiplier(0);
        }
        if (choice == 1) {//strong but brute-like
            this.race = "Orc";
            setAttackMultiplier(.2);
            setAccuracyMultiplier(-.1);
            setSpeedMultiplier(0);
            setDefensiveMultiplier(.05);

        }
        if (choice == 2) {//hardy and good with armor, clumsy.
            this.race = "Dwarf";
            setAttackMultiplier(.1);
            setAccuracyMultiplier(.3);
            setAccuracyMultiplier(-.2);
            setSpeedMultiplier(-.1);
        }
        if (choice == 3) {//your friendly neighborhood stealth archer
            this.race = "Elf";
            setAttackMultiplier(-.2);
            setAccuracyMultiplier(.3);
            setSpeedMultiplier(.25);
            setDefensiveMultiplier(0);

        }
        if (choice == 4) {//a breed between an elf an a human
            this.race = "Halfling";
            setAttackMultiplier(-.1);
            setDefensiveMultiplier(-.1);
            setAccuracyMultiplier(.15);
            setSpeedMultiplier(.1);
        }
    }
    public String getRace(){
        return race;
    }
    public void setRace(String NewRace){
        this.race = NewRace;
    }

    public void role() {//should change stats by plus two to three to keep balance
        String[] buttons = {"Swordsman", "Ranger", "Mage", "Berserker", "Monk"};

        int choice = JOptionPane.showOptionDialog(null, "Which type of Savior would you like to play as?", "",
                JOptionPane.PLAIN_MESSAGE, 1, null, buttons, null);
        String role = "";
        if (choice == 0) {
            this.role = "Warrior"; //blade and physical attacks
            setAttackMultiplier(.2);
            setDefensiveMultiplier(.1);
            setAccuracyMultiplier(0);
            setAttack1("Slash");
            setAttack2("Stab");
            setAttack3("Shield Bash");
            setAttack4("");
        }
        if (choice == 1) {
            this.role = "Ranger"; //ranged attacks and weaker physical attacks
            setAccuracyMultiplier(.3);
            setAttackMultiplier(.1);
            setDefensiveMultiplier(-.1);
            setAttack1("Dual Shot");
            setAttack2("Bow Shot");
            setAttack3("Stab");
            setAttack4("");
        }
        if (choice == 2) {
            this.role = "Mage"; //magic and some weaker physical attacks
            setDefensiveMultiplier(-.1);
            setAttackMultiplier(.3);
            setAccuracyMultiplier(.1);
            setAttack1("Hex");
            setAttack2("Shadow Bolt");
            setAttack3("Sparks");
            setAttack4("");
        }
        if (choice == 3) {
            this.role = "Berserker"; //brute force!
            setDefensiveMultiplier(-.1);
            setAttackMultiplier(.4);
            setAccuracyMultiplier(-.1);
            setAttack1("Punch");
            setAttack2("Blood Lust");
            setAttack3("Rend");
            setAttack4("");
        }
        if (choice == 4) {
            this.role = "Monk"; //self healing and attacking people with physical attacks
            setAccuracyMultiplier(-.2);
            setAttackMultiplier(.2);
            setDefensiveMultiplier(.3);
            setAttack1("Meditation");
            setAttack2("Punch");
            setAttack3("Flying Jump Kick");
            setAttack4("");
        }
    }
    public String getRole(){
        return role;
    }
    public void setRole(String NewRole){
        this.role = NewRole;
    }

    public double getAccuracyMultiplier() {
        return accuracyMultiplier;
    }
    public void setAccuracyMultiplier(double x){
        this.accuracyMultiplier += x;
        if (this.accuracyMultiplier <= 0)
            this.accuracyMultiplier = 0;
    }

    public double getAttackMultiplier(){
        return attackMultiplier;
    }
    public void setAttackMultiplier(double x){
        this.attackMultiplier += x;
        if (this.attackMultiplier <= 0)
            this.attackMultiplier = 0;
    }

    public double getDefensiveMultiplier(){
        return defensiveMultiplier;
    }
    public void setDefensiveMultiplier(double x){
        this.defensiveMultiplier += x;
        if (this.defensiveMultiplier <= 0)
            this.defensiveMultiplier = 0;
    }

    public double getSpeedMultiplier(){
        return speedMultiplier;
    }
    public void setSpeedMultiplier(double x){
        this.speedMultiplier += x;
        if (this.speedMultiplier <= 0)
            this.speedMultiplier = 0;
    }

    public String getAttack1(){
        return attack1;
    }
    public void setAttack1(String a){
        this.attack1 = a;
    }

    public String getAttack2(){
        return attack2;
    }
    public void setAttack2(String a){
        this.attack2 = a;
    }

    public String getAttack3(){
        return attack3;
    }
    public void setAttack3(String a){
        this.attack3 = a;
    }

    public String getAttack4() { return attack4; }
    public void setAttack4(String a){
        this.attack4 = a;
    }

}