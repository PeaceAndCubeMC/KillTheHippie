package fr.peaceandcube.killthehippie.fullflowers;

import fr.peaceandcube.killthehippie.scenariolisteners.FullFlowersListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FlowersGui implements Listener {
    private final Inventory inv;

    public FlowersGui(Player player) {
        this.inv = Bukkit.createInventory(null, 36, "Scénario FullFlowers");

        for (int i = 0; i < 9; i++) {
            this.inv.setItem(i, new ItemStack(FullFlowersListener.FLOWERS.get(i)));
        }

        for (int i = 9; i < 18; i++) {
            Material glassPane = Material.RED_STAINED_GLASS_PANE;
            if (FullFlowersListener.flowersByPlayer.get(player).contains(FullFlowersListener.FLOWERS.get(i - 9))) {
                glassPane = Material.LIME_STAINED_GLASS_PANE;
            }

            this.inv.setItem(i, new ItemStack(glassPane));
        }

        for (int i = 18; i < 26; i++) {
            this.inv.setItem(i, new ItemStack(FullFlowersListener.FLOWERS.get(i - 9)));
        }

        for (int i = 27; i < 35; i++) {
            Material glassPane = Material.RED_STAINED_GLASS_PANE;
            if (FullFlowersListener.flowersByPlayer.get(player).contains(FullFlowersListener.FLOWERS.get(i - 18))) {
                glassPane = Material.LIME_STAINED_GLASS_PANE;
            }

            this.inv.setItem(i, new ItemStack(glassPane));
        }
    }

    public void openInventory(Player player) {
        player.openInventory(this.inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().equals(this.inv)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getInventory().equals(this.inv)) {
            e.setCancelled(true);
        }
    }
}
