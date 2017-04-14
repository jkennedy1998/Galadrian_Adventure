package cartography;

public class BoardDatabase {

    public static Board getBoard(String name){
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
        board.movings.add(new Moving(5,14,board,"goblin",false));
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(10, 0, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        board.walls.get(0).addSquareFloor(0,0,16,16,true);
        board.addNonWall(NonWallsDatabase.makeNonWall(12,7,0,"camp site",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(10,7,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(10,8,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(9,7,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(6,6,0,"tall grass",board));

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
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(3, 9, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        {
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(4, 0, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        board.walls.get(0).addSquareFloor(0,0,7,11,true);

        board.addNonWall(NonWallsDatabase.makeNonWall(2,2,0,"mimic",board));
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
            NonWalls boardDoor = NonWallsDatabase.makeNonWall(13, 11, 0, "board door",board);
            boardDoor.board = board;
            board.addNonWall(boardDoor);
        }
        board.walls.get(0).addSquareFloor(0,0,21,13,true);

        board.addNonWall(NonWallsDatabase.makeNonWall(4,4,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(4,5,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(5,5,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(5,4,0,"tall grass",board));
        board.addNonWall(NonWallsDatabase.makeNonWall(6,6,0,"tall grass",board));
        return board;
    }


}
