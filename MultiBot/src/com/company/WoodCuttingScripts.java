package com.company;

import org.rspeer.runetek.adapter.scene.Pickable;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.scene.Pickables;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.ui.Log;

import static java.lang.Thread.sleep;

public class WoodCuttingScripts {
    int bronzeAnimationCode = 879;
    int steelAnimationCode = 875;
    int mithAnimationCode = 871;
    int adamAnimationCode = 869;
    int runeAnimationCode = 867;
    int dragonAnimationCode = 865;
    private boolean currentlyDropping = false;
    private boolean inTravel = false;
    Player me = Players.getLocal();
    int woodCuttingAnimationId = runeAnimationCode;


    public synchronized void woodCutter(MultiBotMenu gui, String typeOfLogs) {
        SceneObject tree = SceneObjects.getNearest("Teak");
        gui.setStartBool(true);
        if (!currentlyDropping) {
            Pickable nest = Pickables.getNearest("Bird nest");
            if (tree != null && me.getAnimation() != woodCuttingAnimationId && !inTravel) {
                inTravel = true;
                tree.interact("Chop down");
                Time.sleepUntil(() -> me.getAnimation() == -1, 1000, 10000);
                if(me.getAnimation() == woodCuttingAnimationId) {
                    Log.info("Chopping!");
                    inTravel = false;
                }
            } else {
                inTravel = false;
                Log.info("Current Animation ID= " + me.getAnimation());
            }

            if (Inventory.isFull()) {
                currentlyDropping = true;
                int logcount = Inventory.getCount(typeOfLogs);
                Log.info("Log count= " + logcount);
                while (logcount > 1) {
                    for (int i = logcount; i > 0; i--) {
                        if (Inventory.getItemAt(i) != null && Inventory.getItemAt(i).getName().equals(typeOfLogs)) {
                            Inventory.getItemAt(i).interact("Drop");
                        }
                        try {
                            sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.info(logcount);
//                            Inventory.getFirst("Oak logs").interact("Drop");
                    logcount = Inventory.getCount(typeOfLogs);
                }
                currentlyDropping = false;
            }

            if (!Inventory.isFull() && nest != null) {
                nest.interact("Take");
            }
        }
    }
}
