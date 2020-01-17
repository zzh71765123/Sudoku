package utils;

/**
 * 格式化工具类
 */
public class FormatUtils {

    /**
     * 打印二维数组到控制台
     */
    public static void printArray(int[][] grids) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grids[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("_");
    }

    /**
     * 格式化输出的matrix
     * @param grids
     * @return
     */
    public static String formatArray(int[][] grids){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(grids[i][j]);
            }
            sb.append("\n");
        }
        sb.append("_\n");

        return sb.toString();
    }
}

