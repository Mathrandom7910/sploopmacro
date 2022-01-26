package me.just.sploopmacro.keyboard.objectplace;

import me.just.sploopmacro.keyboard.KeyBoardPresser;

import java.awt.event.KeyEvent;

public class Placer {
    private KeyBoardPresser placeKey;
    private KeyBoardPresser key1 = new KeyBoardPresser(KeyEvent.VK_1);
    private KeyBoardPresser keySpace = new KeyBoardPresser(KeyEvent.VK_SPACE);

    public Placer(int keyInt){
        placeKey = new KeyBoardPresser(keyInt);
    }


    public void place(int delay){
        placeKey.press(delay);
        keySpace.press(delay);
        key1.press(delay);
    }

    public void setDefaultDelay(long delay){
        placeKey.defaultDelay = delay;
        key1.defaultDelay = delay;
        keySpace.defaultDelay = delay;
    }
}
