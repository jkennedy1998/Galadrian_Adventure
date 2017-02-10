/**
 * Created by citim on 2/10/2017.
 */
public class Timer {
    private int activeTime = 500;
    public double playerSpeed,monsterSpeed, playerTick, monsterTick;
    public Timer (double playerSpeed, double monsterSpeed){
        this.playerSpeed = playerSpeed;
        this.monsterSpeed = monsterSpeed;
    }
    public int determineNextHit(){ //returns 0 as player, 1 as monster
        while(playerTick < activeTime && monsterTick < activeTime){
            playerTick += playerSpeed;
            monsterTick += monsterSpeed;
        }
        if (playerTick >= activeTime && monsterTick >= activeTime){
            if (playerTick > monsterTick){
                playerTick -= activeTime;
                return 0;
            }
            else {
                monsterTick -= activeTime;
                return 1;
            }
        }
        else if (playerTick >= activeTime) {
            playerTick -= activeTime;
            return 0;
        }
        else{
            monsterTick -= activeTime;
            return 1;
        }
    }
}
