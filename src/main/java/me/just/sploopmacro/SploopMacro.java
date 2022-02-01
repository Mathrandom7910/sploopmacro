package me.just.sploopmacro;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import me.just.sploopmacro.file.FileHndler;
import me.just.sploopmacro.gui.Gui;
import me.just.sploopmacro.keyboard.objectplace.obj.*;
import me.just.sploopmacro.update.UpdateChecker;

import javax.swing.*;
import java.util.HashMap;

//built different
public class SploopMacro {
    public static final String MACRO_VERSION = "1";
    private static boolean running = true;
    private static GlobalKeyboardHook keyboardHook;

    public static UpdateChecker checker = new UpdateChecker();

    private static Spike spike = new Spike();
    private static Trap trap = new Trap();
    private static Mill mill = new Mill();
    private static SpecialObj special = new SpecialObj();
    private static Food food = new Food();

    private static Gui gui = new Gui();

    private static Integer[] keyDetection = new Integer[]{GlobalKeyEvent.VK_V, GlobalKeyEvent.VK_F, GlobalKeyEvent.VK_N, GlobalKeyEvent.VK_H, GlobalKeyEvent.VK_Q};
    public static void main(String[] args){

            FileHndler.init();
            if(FileHndler.isFirstRun) {
                gui.info("Thanks for using this... ig\nIf you installed this from any other place besides\n" + checker.mInfObj.latestRelease + "\nYou could be in danger! (of a virus, malware, etc)", "First Run Info");
            }

            keyboardHook = new GlobalKeyboardHook(true);

            HashMap<Integer, Boolean> keysPressed = new HashMap<>();

            for (Integer key : keyDetection) {
                keysPressed.put(key, false);
            }

            keyboardHook.addKeyListener(new GlobalKeyAdapter() {
                @Override
                public void keyPressed(GlobalKeyEvent e) {
                    if (e.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE) {
                        System.out.println("Escape key pressed, stopping");
                        running = false;
                    }

                    keysPressed.put(e.getVirtualKeyCode(), true);
                }

                @Override
                public void keyReleased(GlobalKeyEvent e) {
                    keysPressed.put(e.getVirtualKeyCode(), false);
                }
            });

            System.out.println("SploopHack v2 ready");
            try {
                while (running && gui.guiOpen) {
                    if (gui.loopTickDel != 0) Thread.sleep(gui.loopTickDel);
                    if (keysPressed.get(GlobalKeyEvent.VK_V)) {
                        spike.place(gui.placeDel);
                    }

                    if (keysPressed.get(GlobalKeyEvent.VK_F)) {
                        trap.place(gui.placeDel);
                    }

                    if (keysPressed.get(GlobalKeyEvent.VK_N)) {
                        mill.place(gui.placeDel);
                    }

                    if (keysPressed.get(GlobalKeyEvent.VK_H)) {
                        special.place(gui.placeDel);
                    }

                    if (keysPressed.get(GlobalKeyEvent.VK_Q)) {
                        food.place(gui.placeDel);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                keyboardHook.shutdownHook();
            }

    }

}
