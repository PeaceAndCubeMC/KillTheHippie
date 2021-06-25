package fr.peaceandcube.killthehippie.scenariolisteners;

import com.gmail.val59000mc.events.UhcStartedEvent;
import com.gmail.val59000mc.exceptions.UhcPlayerNotOnlineException;
import com.gmail.val59000mc.scenarios.ScenarioListener;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;

public class FoodStartListener extends ScenarioListener {

    @EventHandler
    public void onGameStart(UhcStartedEvent e) {
        e.getPlayerManager().getOnlinePlayingPlayers().forEach(player -> {
            try {
                player.getPlayer().getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 10));
            } catch (UhcPlayerNotOnlineException ignored) {
            }
        });
    }
}
