import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String menu = "";
        Board puzzle = new Board();

        while(!menu.equals("6")) {
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
                    new BFS().alg(new Board(puzzle));
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