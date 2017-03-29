package cartography;

public class BoardDatabase {

    public static Board getBoard(String name){
        if (name.equalsIgnoreCase("spawn")) return spawn();
        if(name.equals("yaun-ti cave entrance")) return yaunCaveEntrance();
        if(name.equals("yaun-ti cave")) return yaunCave();
        if(name.equals("yaun-ti cave t")) return yaunCaveT();

        System.out.println("error: getBoard called with an invalid name");
        return null;
    }
    //how to display complex nonWall objects:
    //board door:
    //{
    //NonWalls boardDoor = NonwallsDatabase.makeNonWall(x,y,elevation,"board door");
    //boardDoor.board = board;
    //board.addNonWall(boardDoor)
    //}
    //  then you must set their links in the Map class (equal to the nonwall its lnked to. use findNonWall and its coords that you wrote to find the other door).

    public static Board yaunCaveEntrance(){
        Board board = new Board(15,15);
        {
            board.walls.get(0).addSquare(0,0,9,5,true);
            board.walls.get(0).addSquare(12,0,3,6,true);
            int[] x = {10,11,9},
                    y = {4,0,4};
            board.walls.get(0).addWall(x,y);
        }
            board.movings.add(new Moving(11, 4, board, "yaun-ti holy guard", false));
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(10, 0, 0, "board door");
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        return board;
    }
    public static Board yaunCave(){
        Board board = new Board(6,10);
        {
            board.walls.get(0).addSquare(0,0,6,10,false);
            board.walls.get(0).deleteWall(3,9);
            board.walls.get(0).deleteWall(4,0);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(3, 9, 0, "board door");
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(4, 0, 0, "board door");
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        return board;
    }
    public static Board yaunCaveT(){
        Board board = new Board(20,12);
        {
            board.walls.get(0).addSquare(0,0,20,12,false);
            board.walls.get(0).addSquare(0,7,10,5,true);
            board.walls.get(0).addSquare(16,8,4,4,true);
            board.walls.get(0).deleteWall(13,11);
            board.walls.get(0).addSquare(0,1,20,1,true);
            board.walls.get(0).addSquare(7,6,3,3,true);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(13, 11, 0, "board door");
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        return board;
    }
    public static Board spawn(){
        Board board = new Board(15,15);
        {
            board.walls.get(0).addSquare(0,0,15,15, false);
            board.walls.get(0).addSquare(5,7,5,5, false);
            board.walls.get(0).deleteWall(5,9);
            {
                NonWalls door = NonWallsDatabase.makeNonWall(5, 9, 0, "closed door");
                NonWalls pressurePlate = NonWallsDatabase.makeNonWall(8, 8, 0, "pressure plate");
                pressurePlate.link = door;
                board.addNonWall(door);
                board.addNonWall(pressurePlate);
            }
            {
                NonWalls pressurePlate = NonWallsDatabase.makeNonWall(7, 2, 0, "pressure plate");
                NonWalls dartTrap = NonWallsDatabase.makeNonWall(5, 2, 0, "dart trap");
                dartTrap.board = board;
                dartTrap.facing = 2;
                pressurePlate.link = dartTrap;
                board.addNonWall(pressurePlate);
                board.addNonWall(dartTrap);
            }
            {
                NonWalls sign = NonWallsDatabase.makeNonWall(2,2,0,"sign");
                sign.description = "This is a sign!";
                board.addNonWall(sign);
            }
            {
                NonWalls sign = NonWallsDatabase.makeNonWall(2,5,0,"sign");
                sign.description = "This is a sign too!";
                board.addNonWall(sign);
            }
            board.addNonWall(NonWallsDatabase.makeNonWall(12,12,0,"camp site"));
            Moving goblin = new Moving(7,12,board,"goblin",false);
            board.movings.add(goblin);

        }
        return board;
    }

}
