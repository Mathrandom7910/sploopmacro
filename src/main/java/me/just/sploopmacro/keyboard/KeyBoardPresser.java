package me.just.sploopmacro.keyboard;


import java.awt.*;


public class KeyBoardPresser {

    private Robot r;
    private int keyPressKey;
    public long defaultDelay = 0;

    public KeyBoardPresser(int virtualKey) {
        try{
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        keyPressKey = virtualKey;
    }

    private void sleep(long millis) {
        if(millis == 0) return;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void down(){
        r.keyPress(keyPressKey);
    }

    public void release(){
        r.keyRelease(keyPressKey);
    }

    public void press(int delay) {
        down();
        sleep(delay);
        release();
        sleep(delay);
    }
}
