package utils;

/**
 * Array工具类
 */
public class ArrayUtils {

    /**
     * 二维数组深拷贝
     * @param array
     * @return
     */
    public static int[][] cloneArray(int[][] array){
        int[][] result = new int[9][9];
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                result[i][j] = array[i][j];
            }
        }

        return result;
    }
}
