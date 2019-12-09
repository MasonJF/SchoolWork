package com.company;

import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.component.tab.Magic;
import org.rspeer.runetek.api.component.tab.Spell;
import org.rspeer.script.Script;
import org.rspeer.ui.Log;
import com.company.Sleep;


public class MagicScripts {
    private int AlchCount = 0;
    private Spell highAlch = Spell.Modern.HIGH_LEVEL_ALCHEMY;

    public void magicHighAlch(MultiBotMenu gui) {
        AlchCount++;
        if (Inventory.getCount(true, "Magic longbow") == 0) { // Stops the script if out of bows
            gui.setStartBool(false);
            Log.fine("Out of Longbows!");
        }
        Magic.cast(highAlch, Inventory.getFirst("Magic longbow"));
        Time.sleep(Random.nextInt(1200, 2200));

        if (AlchCount % 2 == 0) {
            Log.fine("Items Alched=" + AlchCount / 2); // Counter for items alch'd, cast gets used in two different loops, and as such we need to calculate that
        }
    }

}
