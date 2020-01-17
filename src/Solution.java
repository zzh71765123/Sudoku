import creatematrix.SudokuPuzzleMatrixGenerator;
import exception.WrongArgsException;
import solvematrix.SudokuPuzzleSolver;
import utils.FileUtils;
import utils.FormatUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 主类
 */
public class Solution {

    public static void main(String[] args) {

        try {
            if (args != null && args.length == 2) {
                String arg0 = args[0];
                switch (arg0) {
                    case "-c":
                        Integer num = Integer.valueOf(args[1]);
                        if (num > 0) {
                            for (int i = 0; i < num; i++) {
                                SudokuPuzzleMatrixGenerator generator = new SudokuPuzzleMatrixGenerator();
                                FileUtils.writeToTXT(FileUtils.PATH, FormatUtils.formatArray(generator
                                        .createSampleArray()
                                        .generateSudokuArray()
                                        .createEmptySpace()
                                        .build()), FileUtils.MATRIX);
                            }
                        } else {
                            throw new WrongArgsException();
                        }

                        return;
                    case "-s":
                        System.out.println("-s");
                        ArrayList<int[][]> matrixs = FileUtils.readMatrixFromTxt(args[1], FileUtils.MATRIX);

                        for (int[][] matrix : matrixs) {
                            SudokuPuzzleSolver
                                    .create()
                                    .initMatrix(matrix)
                                    .solve();
                        }
                        return;
                    default:
                        System.out.println("default");
                        throw new WrongArgsException();
                }

            } else {
                throw new WrongArgsException();
            }
        } catch (WrongArgsException e) {
            System.out.println("请输入正确的参数");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
