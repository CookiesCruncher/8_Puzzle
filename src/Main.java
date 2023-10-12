import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String menu = "";
        Board puzzle = new Board();
        Board sample = new Board();

        while(!menu.equals("6")) {
            sample.table [0][0] = 0;
            sample.table [0][1] = 2;
            sample.table [0][2] = 3;
            sample.table [1][0] = 1;
            sample.table [1][1] = 8;
            sample.table [1][2] = 4;
            sample.table [2][0] = 7;
            sample.table [2][1] = 6;
            sample.table [2][2] = 5;

            System.out.print("1. Create Puzzle\n" +
                    "2. Breadth-First Search\n" +
                    "3. Uniform-CostSearch\n" +
                    "4. Best-First Search\n" +
                    "5. A* Algorithm\n" +
                    "6. Exit\n" +
                    ">: ");
            menu = reader.nextLine();

            switch (menu){

                case "1":
                    puzzle.random();
                    continue;

                case "2":
                    Board bfs = new BFS().alg(new Board(puzzle.table));
                    continue;
            }
        }

        reader.close();
    }

    public static void print(int[][] table){
        for(int column = 0; column < 3; column++){
            for(int row = 0; row < 3; row++) {
                System.out.print(table[column][row]);
            }
            System.out.println();
        }
    }
}