package cartography;

/**
 * Created by citim on 5/4/2017.
 */
public class ProjectileManager extends Thread {
    boolean sleeping = false;
    public ProjectileManager(){

    }
    public void project(Projectile projectile){
        projectile.board.movings.add(projectile);
        projectile.start();
        sleeping = true;
        try{
            Thread.sleep(projectile.milisOfRecoil);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("error with sleeping");
        }
        sleeping = false;
        try{
            join();
        }catch (Exception e){
            System.out.println(e);
            System.out.println("error with joining");
        }
    }
}
