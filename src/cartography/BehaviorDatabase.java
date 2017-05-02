package cartography;
import Battle.monsterSelection;
public class BehaviorDatabase {
    public static String getBehavior(Mob moving){
        return monsterSelection.fetchBeastStats(moving.name)[13];
    }
    public static int[] respond(Mob actingEntity){//add random movement
        if (actingEntity.behavior.equals("follow")) return follow(actingEntity);
        if (actingEntity.behavior.equals("flee")) return flee(actingEntity);
        if (actingEntity.behavior.equals("wander")) return wander();
        if (actingEntity.behavior.equals("stand")) return stand();
        if (actingEntity.behavior.equals("guard")) return guard(actingEntity);

        if (actingEntity.behavior.substring(0,6).equals("linear")) return linear(actingEntity);
        System.out.println("error: behavior ("+actingEntity.behavior+") not valid for "+actingEntity.name);
        return null;
    }
    public static Moving findVisibleEntity(Mob actingEntity){
        Mob lockedEntity = null;
        for (int scan = 0; scan < actingEntity.board.movings.size(); scan++){
            if (inProximity((Mob)actingEntity.board.movings.get(scan), actingEntity)){
                lockedEntity = (Mob)actingEntity.board.movings.get(scan);

            }
        }
        return lockedEntity;
    }
    public static boolean inProximity (Mob entity,Mob actingEntity){return  (!(Math.sqrt(Math.pow(Math.abs(entity.xPosition - actingEntity.xPosition),2)+Math.pow(Math.abs(entity.yPosition - actingEntity.yPosition),2)) > actingEntity.range*30)&&entity.behavior.equals("player")&&entity.elevation == actingEntity.elevation);}

    private static int[] linear(Mob actingEntity){
        if(actingEntity.behavior.equals("linear up")) return new int[] {0,-1};
        if(actingEntity.behavior.equals("linear down")) return new int[] {0,1};
        if(actingEntity.behavior.equals("linear left")) return new int[] {-1,0};
        if(actingEntity.behavior.equals("linear right")) return new int[] {1,0};
        System.out.println("error: linear movement not assigned correctly for Moving's behavior");
        return null;
    }
    private static int[] guard( Mob actingEntity){
        actingEntity.range = 2;

        Moving lockedEntity = findVisibleEntity(actingEntity);
        if (lockedEntity == null){
            if (actingEntity.initialX != actingEntity.xPosition || actingEntity.intitialY != actingEntity.yPosition){
                int[] movement = {0,0};
                if (actingEntity.initialX*30 > actingEntity.xPosition) movement[0] = 1;
                if (actingEntity.initialX*30 < actingEntity.xPosition) movement[0] = -1;
                if (actingEntity.intitialY*30 > actingEntity.yPosition) movement[1] = 1;
                if (actingEntity.intitialY*30 < actingEntity.yPosition) movement[1] = -1;
                int temp = actingEntity.questionWallCollision(movement[0], movement[1]);
                if (temp == 1) movement[0] = 0;
                else if (temp == 2) movement[1] = 0;
                if (temp ==1&&movement[1] == 0) movement[1] += randomMove();
                if (temp ==2&&movement[0] == 0) movement[0] += randomMove();
                if( movement[0] == 0 && movement[1] == 0 && Math.random()>.7) movement = wander();

                return movement;
            }else
            return stand();
        }
        int[] movement = {0,0};
        if (lockedEntity.xPosition > actingEntity.xPosition) movement[0] = 1;
        if (lockedEntity.xPosition < actingEntity.xPosition) movement[0] = -1;
        if (lockedEntity.yPosition > actingEntity.yPosition) movement[1] = 1;
        if (lockedEntity.yPosition < actingEntity.yPosition) movement[1] = -1;
        int temp = actingEntity.questionWallCollision(movement[0], movement[1]);
        if (temp == 1) movement[0] = 0;
        else if (temp == 2) movement[1] = 0;
        if (temp ==1&&movement[1] == 0) movement[1] += randomMove();
        if (temp ==2&&movement[0] == 0) movement[0] += randomMove();
        if( movement[0] == 0 && movement[1] == 0 && Math.random()>.7) movement = wander();

        return movement;
    }
    private static int[] follow(Mob actingEntity){

        Moving lockedEntity = findVisibleEntity(actingEntity);
        if (lockedEntity == null) if( Math.random()>.7) {return wander();} else return stand();
        int[] movement = {0,0};
            if (lockedEntity.xPosition > actingEntity.xPosition) movement[0] = 1;
            if (lockedEntity.xPosition < actingEntity.xPosition) movement[0] = -1;
            if (lockedEntity.yPosition > actingEntity.yPosition) movement[1] = 1;
            if (lockedEntity.yPosition < actingEntity.yPosition) movement[1] = -1;
        int temp = actingEntity.questionWallCollision(movement[0], movement[1]);
        if (temp == 1) movement[0] = 0;
        else if (temp == 2) movement[1] = 0;
        if (temp ==1&&movement[1] == 0) movement[1] += randomMove();
        if (temp ==2&&movement[0] == 0) movement[0] += randomMove();
        if( movement[0] == 0 && movement[1] == 0 && Math.random()>.7) movement = wander();

        return movement;
    }
    private static int randomMove(){
        int temp2 = (int) Math.round(Math.random());
        if (temp2 == 0) return -1;
        else return 1;
    }
    private static int[] flee(Mob actingEntity){
        Moving lockedEntity = findVisibleEntity(actingEntity);
        if (lockedEntity.name.equals("empty")) if( Math.random()>.7) {return wander();} else return stand();
        int[] movement = {0,0};
        if (lockedEntity.xPosition > actingEntity.xPosition) movement[0] = -1;
        if (lockedEntity.xPosition < actingEntity.xPosition) movement[0] = 1;
        if (lockedEntity.yPosition > actingEntity.yPosition) movement[1] = -1;
        if (lockedEntity.yPosition < actingEntity.yPosition) movement[1] = 1;
        int temp = actingEntity.questionWallCollision(movement[0], movement[1]);
        if (temp == 1) movement[0] = 0;
        else if (temp == 2) movement[1] = 0;
        if (temp ==1&&movement[1] == 0) movement[1] += randomMove();
        if (temp ==2&&movement[0] == 0) movement[0] += randomMove();
        return movement;
    }
    private static int[] stand(){return new int[] {0,0};}
    private static int[] wander(){
        int[] movement = {0,0};
        int temp = randomMove();
        if (temp == -1) movement[0] = randomMove();
        if (temp == 1)movement[1] = randomMove();
        return movement;
    }
}
