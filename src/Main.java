import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Minesweeper Game");
            System.out.print("Enter the row: ");
            int row = scanner.nextInt();
            System.out.print("Enter the column: ");
            int column = scanner.nextInt();


            // This loop checks whether the number of rows and columns entered by the user is less than 2.
            // If any of them is less than 2, the user is shown an appropriate error message
            // and is asked for row and column numbers again.
            while (row < 2 || column < 2) {
                System.out.println("The number of rows and columns must be at least 2x2");
                System.out.print("Enter the row: ");
                row = scanner.nextInt();
                System.out.print("Enter the column: ");
                column = scanner.nextInt();

            }

            MineSweeper game = new MineSweeper(row, column);
            game.run();

    }
}

