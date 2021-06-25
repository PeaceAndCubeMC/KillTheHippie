package fr.peaceandcube.killthehippie.scenariolisteners;

import com.gmail.val59000mc.scenarios.ScenarioListener;
import fr.peaceandcube.killthehippie.Messages;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class NetheriteLessListener extends ScenarioListener {

    private static final List<Material> NETHERITE_ITEMS = List.of(
            Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS,
            Material.NETHERITE_BOOTS, Material.NETHERITE_SWORD, Material.NETHERITE_PICKAXE,
            Material.NETHERITE_AXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_HOE
    );

    @EventHandler
    public void onSmithingTableClicked(PlayerInteractEvent e) {
        Block clickedBlock = e.getClickedBlock();

        if (clickedBlock != null && clickedBlock.getType().equals(Material.SMITHING_TABLE)) {
            e.getPlayer().sendMessage(Messages.SCENARIO_NETHERITE_LESS_ERROR);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {
        ItemStack item = e.getEntity().getItemStack();

        if (NETHERITE_ITEMS.contains(item.getType())) {
            e.setCancelled(true);
        }
    }
}
