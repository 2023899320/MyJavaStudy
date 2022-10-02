import java.util.ArrayList;

public class SparseArray {

    public static int[][] toSparseArray(int[][] array, int t) {
        class count {
            int x;
            int y;
            int val;

            public count(int x, int y, int val) {
                this.x = x;
                this.y = y;
                this.val = val;
            }
        }
        ArrayList<count> counts = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != t) {
                    counts.add(new count(i, j, array[i][j]));
                }
            }
        }
        int[][] result = new int[counts.size() + 1][3];
        result[0] = new int[]{array.length, array[0].length, counts.size()};
        for (int i = 1; i <= counts.size(); i++) {
            var count = counts.get(i - 1);
            result[i] = new int[]{count.x, count.y, count.val};
        }
        return result;
    }

    public static void traverse(int[][] array) {
        for (var i : array) {
            for (var j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] toNormalArray(int[][] array, int t) {
        int[][] ints = new int[array[0][0]][array[0][1]];
        for (int i = 1; i < array.length ; i++) {
            ints[array[i][0]][array[i][1]]=array[i][2];
        }
        return ints;

    }

    public static void main(String[] args) {
        int[][] ints = new int[10][10];
        ints[5][5] = 1;
        ints[1][7] = 1;
        ints[9][9]=1;
        traverse(ints);
        System.out.println("================================");
        int[][] sa = toSparseArray(ints, 0);
        traverse(sa);
        System.out.println("================================");
        traverse(toNormalArray(sa,0));
    }
}
