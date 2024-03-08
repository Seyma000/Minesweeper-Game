import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    // define values
    public char[][] map;
    public char[][] board;
    public int row;
    public int column;
    public int mines;

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    // constructor method
    public MineSweeper(int row, int column) {
        this.row = row;
        this.column = column;
        this.map = new char[row][column];
        this.board = new char[row][column];
        this.mines = row * column / 4;
    }

    // The purpose of this method is to start the game and manage the basic flow of the game.
    public void run() {
        prepareGame(); // calls the method of placing random mines on the map
        createMap(); // calls the method that creates the board and map matrices
        printBoard(); // calls the method that prints the board matrix to the screen
        printMap();
        boolean[][] selectedCoordinates=new boolean[row][column];

        // The game continuously receives input from the user within this loop
        // and checks whether the game is won or lost.
        while (true) {
            System.out.print("Enter the row: ");
            int selectedRow = scanner.nextInt();
            System.out.print("Enter the column: ");
            int selectedColumn = scanner.nextInt();

            // checks the validity of the coordinates entered by the user
            if (selectedRow < 0 || selectedRow >= row || selectedColumn < 0 || selectedColumn >= column) {
                System.out.println("Invalid coordinates... Please enter a valid coordinate!");
                continue;
            }
            // checks whether the user re-selects a previously selected coordinate
            if (selectedCoordinates[selectedRow][selectedColumn]){
                System.out.println("This coordinate has been selected! Enter another coordinate");
                continue;
            }else selectedCoordinates[selectedRow][selectedColumn]=true;

            // checks whether there is a mine in the cell at the coordinate chosen by the user
            if (map[selectedRow][selectedColumn] == '*') {
                // If there is a mine, the game is considered lost and the 'Game Over' message is printed on the screen.
                System.out.println("Game Over!!");
                printMap();
                break;
            } else {
                openIndex(selectedRow, selectedColumn);
                printBoard();

                if (isWin()) {
                    System.out.println("You Win !");
                    break;
                }
            }
        }

    }

    // In preparation for the game,
    // place the number of mines on the "map" randomly in rows*columns/4.
    public void prepareGame() {
        while (mines > 0) {
            // Determining random row and column numbers
            int randomRow = random.nextInt(row);
            int randomColumn = random.nextInt(column);

            // Checking whether a mine has been placed at this coordinate before.
            if (map[randomRow][randomColumn] != '*') {
                map[randomRow][randomColumn] = '*';
                mines--;
            }
        }
    }

    // This method creates the game map (map) and the board to be shown to the player (board).
    // It starts each cell with the character '-' and only uses the character '*' for mines.
    public void createMap(){
        // This nested loop traverses each row and each row's columns.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] != '*') {
                    map[i][j] = '-';
                }
                board[i][j] = '-';
            }
        }
    }

    // // This method opens a user-selected coordinate and, if there is no mine at the
    // selected coordinate, calculates the number of mines around it and
    // places this number at the corresponding coordinate in the board matrix.
    public void openIndex(int selectedRow, int selectedColumn) {
        if (map[selectedRow][selectedColumn] == '*') {
            return;
        }

        int count = 0;
        for (int i = selectedRow - 1; i <= selectedRow + 1; i++) {
            for (int j = selectedColumn - 1; j <= selectedColumn + 1; j++) {
                if (i >= 0 && i < row && j >= 0 && j < column && map[i][j] == '*') {
                    count++;
                }
            }
        }

        board[selectedRow][selectedColumn] = (char) (count + '0');
    }

    // This method prints the board matrix that will be displayed to the player.
    public void printBoard() {
        System.out.println("===========================");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // This method is used to show the location of mines.
    public void printMap() {
        System.out.println("map");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    // This method determines whether the game has been won by checking
    // if all non-mine coordinates are opened.
    // If all non-mine coordinates are opened, true is returned and
    // the game is considered won. Otherwise, false is returned and the game continues.
    public boolean isWin() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == '-' && map[i][j] != '*') {
                    return false;
                }
            }
        }
        return true;
    }

}
