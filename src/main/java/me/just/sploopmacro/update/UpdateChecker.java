package me.just.sploopmacro.update;

import com.google.gson.Gson;
import me.just.sploopmacro.SploopMacro;
import me.just.sploopmacro.network.GetPageData;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UpdateChecker {
    public boolean outDated = false;
    public ModInfo mInfObj;

    private static final String INFO_URL = "https://raw.githubusercontent.com/Justgamer101/sploopmacro/master/info.json";
    public UpdateChecker(){
        String modInf = GetPageData.page(INFO_URL);
        if(modInf != null){
            Gson gson = new Gson();

            mInfObj = gson.fromJson(modInf, ModInfo.class);
            if(!mInfObj.version.equals(SploopMacro.MACRO_VERSION)){
                outDated = true;

            }
        } else {
            System.out.println("Error with page");
        }
    }

    public void browsePage(){

        try {
            Desktop.getDesktop().browse(new URI(mInfObj.latestRelease));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public class ModInfo {
        public String version;
        public String latestRelease;
    }
}
