package me.just.sploopmacro.file;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHndler {
    public static boolean isFirstRun = false;
    public static File config;

    public static void init(){
        File file = new File(System.getProperty("user.home") + "/ABSOLUTEZEROTMAN/macro/sploop");
        file.mkdirs();
        config = new File(file.getPath() + "/sploopmacro.json");
        if(!config.exists()) {
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isFirstRun = true;
            try {
                PrintWriter printer = new PrintWriter(config);
                printer.print(new Gson().toJson(new Configs()));
                printer.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
