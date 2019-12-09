package com.company;

import org.rspeer.runetek.adapter.scene.Pickable;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.input.menu.tree.PlayerAction;
import org.rspeer.runetek.api.scene.Pickables;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptCategory;
import org.rspeer.script.ScriptMeta;
import org.rspeer.ui.Log;


@ScriptMeta(developer = "Mason Fraser", name = "MultiBot", desc = "Magic, Woodcutting", version = 0.02, category = ScriptCategory.TOOL)
public class Main extends Script {

    private MagicScripts highAlch = new MagicScripts();
    private WoodCuttingScripts woodCutter = new WoodCuttingScripts();
    private MultiBotMenu gui = new MultiBotMenu();

    @Override
    public void onStart(){
        gui.guiMain();
    }
    @Override
    public int loop() {
        if(gui.isStartBool()){
            Log.info("case= " + gui.getDropDownReturn());
            switch (gui.getDropDownReturn()){
                case 0:
                    woodCutter.woodCutter(gui, "Teak logs");
                    break;
                case 1:
                    highAlch.magicHighAlch(gui);
                    break;
            }
        }
        if (Random.nextInt(0, 250) == 0) {
            Sleep.mySleep(Random.nextInt(60000, 240000)); // Random sleep on chance for long period for more human-like usage
        }
//        if (!gui.isStartBool()) {
////            Log.info("The bot has been paused, please click start to resume!");
////            setPaused(true);
//        }
       return Random.nextInt(800, 1000); // Sleep between loops
    }
}
