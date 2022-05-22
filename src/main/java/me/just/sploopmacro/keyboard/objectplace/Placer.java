package me.just.sploopmacro.keyboard.objectplace;

import me.just.sploopmacro.SploopMacro;
import me.just.sploopmacro.keyboard.KeyBoardPresser;
import me.just.sploopmacro.keyboard.KeyDown;

import java.awt.event.KeyEvent;

public class Placer {
    private final KeyBoardPresser placeKey;
    private final KeyBoardPresser key1 = new KeyBoardPresser(KeyEvent.VK_1);
    private final KeyBoardPresser key2 = new KeyBoardPresser(KeyEvent.VK_2);
    private final KeyBoardPresser keySpace = new KeyBoardPresser(KeyEvent.VK_SPACE);

    public Placer(int keyInt){
        placeKey = new KeyBoardPresser(keyInt);
    }


    public void place(int delay){
        placeKey.press(delay);
        keySpace.press(delay);
        if(SploopMacro.keyDown == KeyDown.NUM_1) {
            key1.press(delay);
        } else {
            key2.press(delay);
        }
    }

    public void setDefaultDelay(long delay){
        placeKey.defaultDelay = delay;
        key1.defaultDelay = delay;
        key2.defaultDelay = delay;
        keySpace.defaultDelay = delay;
    }
}
