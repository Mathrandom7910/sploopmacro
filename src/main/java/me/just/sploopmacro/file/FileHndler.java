package me.just.sploopmacro.file;

import java.io.File;
import java.io.IOException;

public class FileHndler {
    public static boolean isFirstRun = false;

    public static void init(){
        File file = new File(System.getProperty("user.home") + "/ABSOLUTEZEROTMAN/macro/sploop"),
                file1;
        file.mkdirs();
        file1 = new File(file.getPath() + "/sploopmacro.json");
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isFirstRun = true;
        }
    }
}
