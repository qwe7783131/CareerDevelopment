package com.bugmaker.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class SaveFileUtil {


    /**
     *
     * @param path 存储路径
     * @param newFileName 文件名
     * @param in 输入流
     * @return
     */
    public static boolean saveFile(String path, String newFileName, InputStream in){
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        try {
            FileOutputStream fos = new FileOutputStream(path + newFileName);
            int b = 0;
            while ((b = in.read()) != -1) {
                fos.write(b);
            }
            fos.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
