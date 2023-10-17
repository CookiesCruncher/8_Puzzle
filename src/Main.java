import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String menu = "";
        Board puzzle = new Board();
        puzzle.setGoal();
        long start, end;


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
                        int [] p_val = new Random()
                                .ints(0, 9)
                                .distinct().limit(9)
                                .toArray();
                        int i = 0;
                        int[][] b = new int[3][3];
                        for (int column = 0; column < 3; column++) {
                            for (int row = 0; row < 3; row++) {
                                b[column][row] = p_val[i];
                                i++;
                            }
                        }
                        puzzle = new Board(b);
                    puzzle.print();
                    break;
                case "2":
                    start = System.nanoTime();
                    BFS bfs = new BFS();
                    Board a = bfs.alg(puzzle);
                    if (a!= null) {
                        a.print();
                        end = System.nanoTime() - start;
                        System.out.println("Nano Time: " + end);
                    }
                    break;
                case "3":
                    start = System.nanoTime();
                    UCS ucs = new UCS();
                    Board j = ucs.alg(puzzle);
                    if(j !=null) {
                        j.print();
                        end = System.nanoTime() - start;
                        System.out.println("Nano Time: " + end);
                    }
                    break;
                case "4":
                    start = System.nanoTime();
                    BestFS best = new BestFS();
                    Board k = best.alg(puzzle);
                    if(k != null) {
                        k.print();
                        end = System.nanoTime() - start;
                        System.out.println("Nano Time: " + end);
                    }
                    break;
                case "5":
                    start = System.nanoTime();
                    Astar star = new Astar();
                    Board d = star.alg(puzzle);
                    if(d != null) {
                        d.print();
                        end = System.nanoTime() - start;
                        System.out.println("Nano Time: " + end);
                    }
                    break;

            }
        }
    }
}