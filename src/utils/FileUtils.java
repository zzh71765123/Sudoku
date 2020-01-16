package utils;

import java.io.*;
import java.util.ArrayList;

/**
 * 文件工具类
 */
public class FileUtils {
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

    public static ArrayList<Integer[][]> readMatrixFromTxt(String path,String fileName) throws IOException {
        ArrayList<Integer[][]> result = new ArrayList<>();
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
            index = 0;
            Integer[][] matrix = new Integer[9][9];
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    matrix[i][j] = (int) s.charAt(index++);
                }
            }
            result.add(matrix);
        }

        return result;
    }
}
