import java.util.HashMap;

public class Board {
    public int [][] table;
    public static HashMap<Integer, Index> goal;
    public int misplace, manhattan_distance, nilsson;
    protected Index z;
    private static HashMap <Integer, Integer> goal_pair;

    public Board(){
        table = new int[3][3];
    }

    public  Board(int[][] i) {
        this();

        for(int y = 0; y < 3; y++) {
            System.arraycopy(i[y], 0, table[y], 0, 3);
        }
    }

    public void setGoal() {
        goal = new HashMap<>();
        goal.put(1,new Index(0,0));
        goal.put(2,new Index(0,1));
        goal.put(3,new Index(0,2));
        goal.put(8,new Index(1,0));
        goal.put(0,new Index(1,1));
        goal.put(4,new Index(1,2));
        goal.put(7,new Index(2,0));
        goal.put(6,new Index(2,1));
        goal.put(5,new Index(2,2));

        goal_pair = new HashMap<>();
        goal_pair.put(1, 2);
        goal_pair.put(2, 3);
        goal_pair.put(3, 4);
        goal_pair.put(4, 5);
        goal_pair.put(5, 6);
        goal_pair.put(6, 7);
        goal_pair.put(7, 8);
        goal_pair.put(8, 0);
    }
    public void setMisplace(){
        misplace = 0;

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                Index i = goal.get(table[y][x]);
                if(y != i.y || x != i.x) {
                    misplace++;
                }
            }
        }
    }

    public void setManhattan_distance() {
        manhattan_distance = 0;

        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                Index i = goal.get(table[y][x]);
                manhattan_distance += Math.abs(y-i.y) + Math.abs(x - i.x);
            }
        }
    }

    public void z_index() {
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if(table[y][x] == 0){
                    z = new Index(y, x);
                    break;
                }
            }
        }
    }
    public void print() {
        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(table[y][x]+" |");
            }
            System.out.println();
        }
    }

    public Board move(String direction) {
        Board temp = new Board(table);
        switch (direction){
            case "UP":
                temp.table[z.y][z.x] = temp.table[z.y - 1][z.x];
                temp.table[z.y - 1][z.x] = 0;
                break;
            case "DOWN":
                temp.table[z.y][z.x] = temp.table[z.y + 1][z.x];
                temp.table[z.y + 1][z.x] = 0;
                break;
            case  "LEFT":
                temp.table[z.y][z.x] = temp.table[z.y][z.x - 1];
                temp.table[z.y][z.x - 1] = 0;
                break;
            case "RIGHT" :
                temp.table[z.y][z.x] = temp.table[z.y][z.x + 1];
                temp.table[z.y][z.x + 1] = 0;
        }
        return temp;
    }
    public Boolean check_goal_m() {
        return misplace == 0;
    }

    public Boolean check_goal_d() {
        return manhattan_distance ==0;
    }

    public void set_nilsson(){
        z_index();
        int distance = Math.abs(z.x - 1) + Math.abs(z.y-1);
        HashMap<Integer,Integer> sequence = pairing();
        int wrong_pair = 0;

        for(int i : goal_pair.keySet()) {
            if(goal_pair.get(i) != sequence.get(i)){
                wrong_pair += 2;
            }
        }
        nilsson = distance + 3*(wrong_pair);
    }

    private HashMap<Integer, Integer> pairing(){
        HashMap <Integer, Integer> sequence = new HashMap<>();
        for(int i = 0; i < 2; i++) {
            sequence.put(table[0][i], table[0][i+1]);
        }
        for(int i = 0; i < 2; i++) {
            sequence.put(table[i][2], table[i+1][2]);
        }
        for(int i = 2; i > 0; i--) {
            sequence.put(table[2][i], table[2][i-1]);
        }
        for(int i = 2; i > 0; i--) {
            sequence.put(table[i][0], table[i-1][0]);
        }
        sequence.put(table[1][0], table[1][1]);
        return sequence;
    }
}
