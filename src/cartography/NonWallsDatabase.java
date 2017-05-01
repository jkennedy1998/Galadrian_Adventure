package cartography;
import Battle.Inventory;
import Battle.Leveler;
import Battle.adventurerework;
public class NonWallsDatabase {

    public static NonWalls makeNonWall(int xPosition, int yPosition, int elevation, String wallType, Board board){ //needs inclusion of nonwall if presets are not true for desired nonwall object

        NonWalls nonwall = new NonWalls(xPosition,yPosition,elevation,wallType,board);
        if(wallType.equals("sign")) {
            nonwall.interactOnUse = true;
            nonwall.colidable = true;
        }
        else if(wallType.equals("small tree")){
            nonwall.interactOnCollision = false;
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
        }
        else if(wallType.equals("boulder")){
            nonwall.interactOnCollision = false;
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
        }
        else if(wallType.equals("item")){
            nonwall.interactOnUse = true;
        }
        else if(wallType.equals("chest")){
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
            nonwall.interactOnCollision = false;
        }
        else if(wallType.equals("mimic")){
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
            nonwall.interactOnCollision = false;
        }
        else if(wallType.equals("open door")){
            nonwall.interactOnUse = true;
        }
        else if(wallType.equals("closed door")){
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
        }

        else if(wallType.equals("locked door")){
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
        }
        else if(wallType.equals("dart trap")) {
            nonwall.colidable = true;
            nonwall.interactOnCollision = false;
        }
        else if(wallType.equals("button")){
            nonwall.interactOnUse = true;
            nonwall.colidable = true;
            nonwall.interactOnCollision = false;
        }
//        else if(wallType.equals("locked door")) nonwall.colidable = true;
        else if (wallType.equals("camp site")){
            nonwall.colidable = true;
            nonwall.interactOnUse = true;
            nonwall.interactOnCollision = false;
        }

        return nonwall;
    }
    public static void findInteraction(Moving moving, NonWalls current){//needs every single nonwall object and aditional nonplayer colide if its a player based object
        if(current.wallType.equals("stairs up")) moving.elevation++;
        else if(current.wallType.equals("stairs down")) moving.elevation--;
        else if(current.wallType.equals("trap door"))moving.elevation-= 1; //make an open trap door. make one visible and the other not visible
        else if(current.wallType.equals("open door"));
        else if(current.wallType.equals("closed door")){
            current.wallType = "open door";
            current.colidable = false;
            current.state = false;
        }
        else if(current.wallType.equals("locked door")&& moving.behavior.equals("player")) {
            adventurerework.window.print("You turn the handle with no avail");
            if(adventurerework.inventory.hasItem("key") != null){
                current.wallType = "open door";
                current.colidable = false;
                current.state = false;
            }

        }
        else if(current.wallType.equals("locked door")&&! moving.behavior.equals("player")) {}
        else if(current.wallType.equals("small tree")){
            adventurerework.window.print("You could probably cut past this with the proper tools.");
            if(adventurerework.inventory.hasItem("wood axe") != null){
                adventurerework.window.print("you grip the handle of your wood axe.");

                String[] buttons = {"chop down the small tree", "put away your wood axe"};
                adventurerework.window.makeButtons(buttons);
                adventurerework.window.drawButtons();
                int choice = -1;
                while(choice == -1){
                    System.out.print("");
                    choice = adventurerework.window.questionButtonClick();
                }
                adventurerework.window.voidButtons();
                if(choice == 0){
                    current.board.removeNonwall(current);
                    adventurerework.inventory.updateItemUse(adventurerework.inventory.hasItem("wood axe"));
                }


            }
        }
        else if(current.wallType.equals("boulder")){
            adventurerework.window.print("You see a crack in the stone");
            adventurerework.window.print("You could probably break it with the right tool");

            if(adventurerework.inventory.hasItem("pick axe") != null){
                adventurerework.window.print("you grip the handle of your pick axe.");

                String[] buttons = {"pick away at the rough", "put away your pick"};
                adventurerework.window.makeButtons(buttons);
                adventurerework.window.drawButtons();
                int choice = -1;
                while(choice == -1){
                    System.out.print("");
                    choice = adventurerework.window.questionButtonClick();
                }
                adventurerework.window.voidButtons();
                if(choice == 0){
                    current.board.removeNonwall(current);
                    adventurerework.inventory.updateItemUse(adventurerework.inventory.hasItem("wood axe"));
                }


            }
        }
        else if(current.wallType.equals("button")){
            if(current.facing == 0 && moving.lastPosition[1] == current.yPosition-1) {
                current.state = !current.state;
                current.checkState();
                current.link.checkState();
            }
            if(current.facing == 1 && moving.lastPosition[0] == current.xPosition+1) {
                current.state = !current.state;
                current.checkState();
                current.link.checkState();
            }
            if(current.facing == 2 && moving.lastPosition[1] == current.yPosition+1) {
                current.state = !current.state;
                current.checkState();
                current.link.checkState();
            }
            if(current.facing == 3 && moving.lastPosition[0] == current.xPosition-1) {
                current.state = !current.state;
                current.checkState();
                current.link.checkState();
            }
        }
        else if(current.wallType.equals("mimic")&&moving.behavior.equals("player")){
            current.board.removeNonwall(current);
            current.board.movings.add(new Moving(current.xPosition,current.yPosition,current.board,"mimic",false));
        }
        else if(current.wallType.equals("mimic")&&!moving.behavior.equals("player"));
        else if(current.wallType.equals("tall grass")){
            if(Math.random()>.9 && moving.behavior.equals("player")){
//                adventurerework.startEncounter(new Moving(-1,-1,moving.board,Battle.monsterSelection.selection(current.board),false));
                System.out.println("random grass encounter. what should be happening?");
            }
        }
        else if(current.wallType.equals("camp site") && moving.behavior.equals("player")){
            if (adventurerework.time > 22 || adventurerework.time < 5){
                adventurerework.window.print("You stumble apon a camp site.");
                String[] buttons = {"sleep through the night", "Stumble your way through the darkness"};
                adventurerework.window.makeButtons(buttons);
                adventurerework.window.drawButtons();
                int choice = -1;
                while(choice == -1){
                    System.out.print("");
                    choice = adventurerework.window.questionButtonClick();
                }
                adventurerework.window.voidButtons();
                if(choice == 0){
                    while (adventurerework.character1.getExp()>= adventurerework.character1.getExpLim()) {
                        adventurerework.levelUp();
                        adventurerework.time += 1;
                    }
                        adventurerework.window.print("The rustling of beasts and critters alike fill the growing void around your camp.");
                        String[] buttons2 = {"Fortify your camp from the creatures of the black", "Take your chances with the surrounding inhabitants and sleep through your worries"};
                        adventurerework.window.makeButtons(buttons2);
                        adventurerework.window.drawButtons();
                        int choice2 = -1;
                        while(choice2 == -1){
                            System.out.print("");
                            choice2 = adventurerework.window.questionButtonClick();
                        }
                        adventurerework.window.voidButtons();
                        if (choice2 == 0){
                            if (Math.random() * 10 > 9)  //10% chance of encounter
                                current.board.movings.add(new Moving(-1,-1,current.board,Battle.monsterSelection.selection(current.board),false));
                            if (adventurerework.time>=24){
                                adventurerework.time = adventurerework.time-24;
                                adventurerework.day++;
                            }
                                adventurerework.character1.setHealth(adventurerework.character1.getHealth() + Leveler.calculateRestingHealth(adventurerework.time));
                            if (adventurerework.character1.getHealth()>adventurerework.character1.getMaxHealth()) adventurerework.character1.setHealth(adventurerework.character1.getMaxHealth());
                            }
                        else{
                            if (Math.random() * 10 > 6)  //40% chance of encounter
                                    current.board.movings.add(new Moving(-1,-1,current.board,Battle.monsterSelection.selection(current.board),false));
                            if (adventurerework.time>=24){
                                adventurerework.time = adventurerework.time-24;
                                adventurerework.day++;
                            }
                                adventurerework.character1.setHealth(adventurerework.character1.getHealth() + Leveler.calculateRestingHealth(adventurerework.time));
                                if (adventurerework.character1.getHealth()>adventurerework.character1.getMaxHealth()) adventurerework.character1.setHealth(adventurerework.character1.getMaxHealth());

                        }
                    }
                else if (choice == 1){
                    adventurerework.window.print("You brave the night with ignorance and brash.");
                }
            }
            else
                adventurerework.window.print("A camp site calls to you, but it is too early to rest.");
        }
        else  if (current.wallType.equals("camp site")  && !moving.behavior.equals("player")); //beasts do nothing at a camp site
        else if(current.wallType.equals("pressure plate")){
            current.state = !current.state;
            current.checkState();
            current.link.checkState();
        }
        else if(current.wallType.equals("board door")&&moving.behavior.equals("player")) {
            if (moving.board == moving.lastBoard) { //this makes sure it doesnt go through doors multiple times.
                moving.xPosition = current.link.xPosition;
                moving.yPosition = current.link.yPosition;
                moving.elevation = current.link.elevation;
                moving.board = current.link.board;
                current.board.removeMoving(moving);
                current.link.board.movings.add(moving);
                adventurerework.window.refreshBoard();
            }
        }
        else if(current.wallType.equals("board door")&&!moving.behavior.equals("player")) {}
        else if (current.wallType.equals("item")&& moving.behavior.equals("player")){
            if(adventurerework.inventory.recieceItem(current.description)){
                current.board.removeNonwall(current);
            }

        }
            else if (current.wallType.equals("item")&& !moving.behavior.equals("player"));//does nothing. this is when an enemy runs into an item
        else if(current.wallType.equals("dart trap")){
            Moving dart = new Moving(current.xPosition,current.yPosition, current.board, "projectile", false);
            current.board.movings.add(dart);
            if(current.facing == 0){ dart.behavior = "linear up";}
            else if(current.facing == 2){ dart.behavior = "linear down";}
            else if(current.facing == 1){ dart.behavior = "linear left";}
            else if(current.facing == 3){ dart.behavior = "linear right";}

        }
        else if(current.wallType.equals("sign") && moving.name.equals("player")){
            String[] strings = {"The sign reads...",current.description};
            adventurerework.window.print(strings);
        }
        else if (current.wallType.equals("sign") && !moving.behavior.equals("player"));//does nothing. this is when an enemy runs into a sign.
        else if(current.wallType.equals("chest") && moving.behavior.equals("player")){
            if(current.description.equals("no item")) adventurerework.window.print("its empty");
            else {
                if(adventurerework.inventory.recieceItem(current.description)) current.description = "no item";

            }
        }
        else if (current.wallType.equals("chest") && !moving.behavior.equals("player"));//does nothing. this is when an enemy runs into a chest.
        else System.out.println("error: wallType isn't set to a legitimate type\nWalltype = ["+current.wallType+"]");
    }
}
