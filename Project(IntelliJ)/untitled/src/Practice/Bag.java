package Practice;

public class Bag {
    public static void main(String[] args) {
        int size = 15;
        int idx = 0;
        int[][] merchandise = {
                {4, 3}, // 사과
                {6, 5}, // 배
                {3, 1}, // 참외
                {10, 7} // 수박
        };
        int[][] table = new int[merchandise.length][size+1];

        for (int i = 1; i <= size; i++) {
            if (i < merchandise[idx][0]) {
                table[idx][i] = 0;
                //System.out.print(table[idx][i] + " ");
                continue;
            }

            table[idx][i] = merchandise[idx][1];
            //System.out.print(table[idx][i] + " ");
        }
        idx++;
        //System.out.println();
        //System.out.println(topdown(idx, size, merchandise, table));

        System.out.println(bottomup(merchandise));
    }

    public static int topdown(int idx, int size, int[][] merchandise, int[][] table) {
        if (table[table.length-1][size] != 0) {
            return table[table.length-1][size];
        }

        for (int i = 1; i <= size; i++) {
            int prev = table[idx-1][i];
            if (i < merchandise[idx][0]) {
                table[idx][i] = prev;
                //System.out.print(table[idx][i] + " ");
                continue;
            }

            int others = i - merchandise[idx][0];
            int cur = merchandise[idx][1] + table[idx-1][others];

            table[idx][i] = prev > cur ? prev : cur;
            //System.out.print(table[idx][i] + " ");
        }
        //System.out.println();

        return topdown(idx+1, size, merchandise, table);
    }

    public static int bottomup(int[][] merchandise) {
        int size = 15;
        int[][] table = new int[merchandise.length][size+1];

        for (int i = 1; i <= size; i++) {
            if (i < merchandise[0][0]) {
                table[0][i] = 0;
                //System.out.print(table[0][i] + " ");
                continue;
            }

            table[0][i] = merchandise[0][1];
            //System.out.print(table[0][i] + " ");
        }
        //System.out.println();

        for (int i = 1; i < merchandise.length; i++) {
            for (int j = 1; j <= size; j++) {
                int prev = table[i-1][j];
                if (j < merchandise[i][0]) {
                    table[i][j] = prev;
                    //System.out.print(table[i][j] + " ");
                    continue;
                }

                int others = j - merchandise[i][0];
                int cur = merchandise[i][1] + table[i - 1][others];

                table[i][j] = prev > cur ? prev : cur;
                //System.out.print(table[i][j] + " ");
            }
            //System.out.println();
        }

        return table[table.length-1][size];
    }
}
