import utils.FileUtils;
import utils.FormatUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        try {
            if (args != null && args.length == 2) {
                String arg0 = args[0];
                switch (arg0) {
                    case "-c":
                        Integer num = Integer.valueOf(args[1]);
                        if (num > 0) {
                            String path = "C:/Users/Shinelon/Desktop/AcmCode";
                            for (int i = 0; i < num; i++) {
                                FileUtils.writeToTXT(path, FormatUtils.formatArray(new SudokuPuzzleMatrixGenerator().generateSudokuArray().createEmptySpace().build()),"test.txt");
                            }
                        } else {
                            throw new WrongArgsException();
                        }

                        return;
                    case "-s":
                        System.out.println("-s");
                        ArrayList<Integer[][]> matrixs = FileUtils.readMatrixFromTxt("C:/Users/Shinelon/Desktop/AcmCode","test.txt");
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
