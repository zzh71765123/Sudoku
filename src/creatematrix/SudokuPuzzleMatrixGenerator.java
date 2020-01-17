package creatematrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 生成终局
 */
public class SudokuPuzzleMatrixGenerator {

    /** 待转换的数组种子数组 */
    private int[][] sampleArray = SeedSudokuMatrixFactory
            .retrieveSeedSudokuArrayByRandom();

    /**
     * 交换
     * @return
     */
    public SudokuPuzzleMatrixGenerator generateSudokuArray() {
        List<Integer> randomList = buildRandomList();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (sampleArray[i][j] == randomList.get(k)) {
                        sampleArray[i][j] = randomList.get((k + 1) % 9);
                        break;
                    }
                }
            }
        }
        return this;
    }

    /**
     * 挖空
     * @return
     */
    public SudokuPuzzleMatrixGenerator createEmptySpace(){
        Random r = new Random();
        Integer x;
        Integer y;
        for(int i = 0 ; i < 15 ; i++){
            x = r.nextInt(8);
            y = r.nextInt(8);
            sampleArray[x][y] = 0;
        }
        return this;
    }

    public int[][] build(){
        return sampleArray;
    }

    private List<Integer> buildRandomList() {
        List<Integer> result = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );
        Collections.shuffle(result);
        return result;
    }

}