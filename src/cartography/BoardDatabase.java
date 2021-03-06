package cartography;

public class BoardDatabase {

    public static Board getBoard(String name){
        if(name.equals("yaun-ti cave entrance")) return yaunCaveEntrance();
        if(name.equals("yaun-ti cave")) return yaunCave();
        if(name.equals("yaun-ti cave t")) return yaunCaveT();
//        if(name.equals("spawn")) return spawn();

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


    public static Board spawn(){
        Board board = new Board(300,300);
        board.getWalls(0).addWall(2,0);
        board.addNonWall(NonWallsDatabase.makeNonWall(4,0,0,"locked door",board));
        board.getWalls(0).addSquareFloor(0,0,10,10,true);
        board.movings.add(new Mob(9,9,0,board,"goblin"));
        return board;
    }
    public static Board yaunCaveEntrance(){
        Board board = new Board(15*30,15*30);
        {
            board.getWalls(0).addSquare(0,0,9,5,true);
            board.getWalls(0).addSquare(12,0,3,6,true);
            int[] x = {10,11,9},
                    y = {4,0,4};
            board.getWalls(0).addWall(x,y);
        }
            board.movings.add(new Mob(11*30+15, 4*30+15,0, board, "yaun-ti holy guard"));
        board.movings.add(new Mob(5*30,14*30,0,board,"goblin"));
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(10, 0, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        board.getWalls(0).addSquareFloor(0,0,16,16,true);
        board.addNonWall(NonWallsDatabase.makeNonWall(12,7,0,"camp site",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(10,7,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(10,8,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(9,7,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(6,6,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(6,7,0,"small tree",board));

        return board;
    }
    public static Board yaunCave(){
        Board board = new Board(6*30,10*30);
        {
            board.getWalls(0).addSquare(0,0,6,10,false);
            board.getWalls(0).deleteWall(3,9);
            board.getWalls(0).deleteWall(4,0);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(3, 9, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(4, 0, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        board.getWalls(0).addSquareFloor(0,0,7,11,true);

        board.addNonWall(NonWallsDatabase.makeNonWall(2,2,0,"mimic",board));
        return board;
    }
    public static Board yaunCaveT(){
        Board board = new Board(20*30,12*30);
        {
            board.getWalls(0).addSquare(0,0,20,12,false);
            board.getWalls(0).addSquare(0,7,10,5,true);
            board.getWalls(0).addSquare(16,8,4,4,true);
            board.getWalls(0).deleteWall(13,11);
            board.getWalls(0).addSquare(0,1,20,1,true);
            board.getWalls(0).addSquare(7,6,3,3,true);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(13, 11, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }

        board.getWalls(0).addSquareFloor(0,0,21,13,true);

        board.addNonWall(NonWallsDatabase.makeNonWall(4,4,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(4,5,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(5,5,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(5,4,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(6,6,0,"tall grass",board));
        Walls secondFloor = new Walls();
        secondFloor.elevation = 1;
        secondFloor.addSquare(0,0,20,12,false);
        secondFloor.addSquare(0,0,20,12,false);
        secondFloor.addSquare(0,7,10,5,true);
        secondFloor.addSquare(16,8,4,4,true);
        secondFloor.addSquare(0,1,20,1,true);
        secondFloor.addSquare(7,6,3,3,true);
        secondFloor.addSquareFloor(0,0,21,4,true);
        secondFloor.addSquareFloor(0,0,4,14,true);

        board.addWalls(secondFloor);
        {
            NonWalls stairsUp = NonWallsDatabase.makeNonWall(2,2,0,"stairs up",board);
            NonWalls stairsDown = NonWallsDatabase.makeNonWall(2,3,1,"stairs down",board);
            board.addNonWall(stairsDown);
            board.addNonWall(stairsUp);
        }
        {
            NonWalls chest = NonWallsDatabase.makeNonWall(3,5,1,"chest",board);
            chest.description = "wood axe";
            board.addNonWall(chest);
        }
        return board;
    }


}
