import java.util.*;

public class Board {

    public int [][] goal;
    public int [][] table;
    public Index z;
    public Map<String,Board> paths;
    public Board() {
        create_goal();
        z = null;
        paths = new HashMap<>();
    }

    public Board(int[][] table) {
        create_goal();
        z = null;
        paths = new HashMap<>();
        paths = new HashMap<>();
        for(int y = 0; y< 3; y++) {
            for ( int x= 0; x < 3; x++) {
                this.table[y][x] = table[y][x];
            }
        }
    }

    public void create_goal(){
        goal = new int[3][3];
        table = new int[3][3];
        goal [0][0] = 1;
        goal [0][1] = 2;
        goal [0][2] = 3;
        goal [1][0] = 8;
        goal [1][1] = 0;
        goal [1][2] = 4;
        goal [2][0] = 7;
        goal [2][1] = 6;
        goal [2][2] = 5;
    }

    public void random() {
        int [] p_val = new Random()
                .ints(0, 9)
                .distinct().limit(9)
                .toArray();

        int i = 0;
        for(int column = 0; column < 3; column++){
            for(int row = 0; row < 3; row++) {
                table[column][row] = p_val[i];
                i++;
            }
        }

        print();
    }

    public Boolean goal_check() {
        for(int y = 0; y < table.length; y ++) {
            for(int x = 0; x < table.length; x++) {
                if(table[y][x] != goal[y][x]){
                    return  false;
                }
            }
        }
        return true;
    }

    public void z_locator() {
        for(int y = 0; y < table.length; y ++) {
            for(int x = 0; x < table.length; x++) {
                if(table[y][x] == 0) {
                    z = new Index(y,x);
                }
            }
        }
    }

    public void avail_paths() {
        Board tmp;
        z_locator();

        if(z.y > 0) {
            tmp = new Board(table);
            tmp.table[z.y][z.x] = tmp.table[z.y - 1][z.x];
            tmp.table[z.y - 1][z.x] = 0;
            paths.put("UP",tmp);
        }
        if(z.y < 2) {
            tmp = new Board(table);
            tmp.table[z.y][z.x] = tmp.table[z.y + 1][z.x];
            tmp.table[z.y + 1][z.x] = 0;
            paths.put("DOWN",tmp);
        }
        if(z.x > 0) {
            tmp = new Board(table);
            tmp.table[z.y][z.x] = tmp.table[z.y][z.x - 1];
            tmp.table[z.y][z.x - 1] = 0;
            paths.put("LEFT",tmp);
        }
        if(z.x < 2) {
            tmp = new Board(table);
            tmp.table[z.y][z.x] = tmp.table[z.y][z.x + 1];
            tmp.table[z.y][z.x + 1] = 0;
            paths.put("RIGHT",tmp);
        }

    }
    public void print() {
        for(int y = 0; y < table.length; y ++) {
            System.out.println(Arrays.toString(table[y]));
        }
        System.out.println();
    }
}
