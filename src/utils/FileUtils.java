package utils;

import java.io.*;
import java.util.ArrayList;

/**
 * 文件工具类
 */
public class FileUtils {

    public static final String PATH = "C:/Users/Shinelon/Desktop/AcmCode";
    public static final String MATRIX = "matrix.txt";
    public static final String SOLVE = "solve.txt";
    /**
     * 写入txt文件
     * @param path
     * @param str
     * @param fileName
     */
    public static void writeToTXT(String path,String str,String fileName){
        FileOutputStream o = null;
        byte[] buff = new byte[]{};
        try{
            File file = new File(path+"/"+fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            buff=str.getBytes();
            o=new FileOutputStream(file,true);
            o.write(buff);
            o.flush();
            o.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 从txt文件读取matrix
     * @param path
     * @param fileName
     * @return
     * @throws IOException
     */
    public static ArrayList<int[][]> readMatrixFromTxt(String path, String fileName) throws IOException {
        ArrayList<int[][]> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path+"/"+fileName));

        String temp = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(temp!=null){
            sb.append(temp);
            temp = br.readLine();
        }

        String[] matrixs = sb.toString().replaceAll("\n","").split("_");
        int index = 0;
        for (String s : matrixs) {
            if(s.length()!=81){
                throw new IOException();
            }
            index = 0;
            int[][] matrix = new int[9][9];
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    char tempChar = s.charAt(index++);
                    if(tempChar<'0'||tempChar>'9'){
                        throw new IOException();
                    }
                    matrix[i][j] = tempChar - '0';
                }
            }
            result.add(matrix);
        }

        return result;
    }

}
