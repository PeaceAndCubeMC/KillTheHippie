package fr.peaceandcube.killthehippie.scenariolisteners;

import com.gmail.val59000mc.events.UhcStartedEvent;
import com.gmail.val59000mc.exceptions.UhcPlayerNotOnlineException;
import com.gmail.val59000mc.scenarios.ScenarioListener;
import com.gmail.val59000mc.utils.RandomUtils;
import fr.peaceandcube.killthehippie.Messages;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class FullFlowersListener extends ScenarioListener {

    public static final List<Material> FLOWERS = List.of(
            Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM,
            Material.AZURE_BLUET, Material.RED_TULIP, Material.ORANGE_TULIP, Material.WHITE_TULIP,
            Material.PINK_TULIP, Material.OXEYE_DAISY, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY,
            Material.WITHER_ROSE, Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY
    );

    public static Map<Player, List<Material>> flowersByPlayer = new HashMap<>();

    @EventHandler
    public void onGameStart(UhcStartedEvent e) {
        this.getPlayerManager().getOnlinePlayingPlayers().forEach(player -> {
            try {
                flowersByPlayer.put(player.getPlayer(), new ArrayList<>());
            } catch (UhcPlayerNotOnlineException ignored) {
            }
        });
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Material type = e.getBlock().getType();
        Player player = e.getPlayer();

        if (FLOWERS.contains(type) && !flowersByPlayer.get(player).contains(type)) {
            flowersByPlayer.get(player).add(type);

            if (this.hasAllFlowers(player)) {
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(30.0D);
                player.setHealth(30.0D);
                player.sendMessage(Messages.SCENARIO_FULL_FLOWERS_COMPLETED);
            }
        }
    }

    @EventHandler
    public void onWitherSkeletonDeath(EntityDeathEvent e) {
        if (e.getEntity() instanceof WitherSkeleton && e.getEntity().getKiller() != null) {
            if (RandomUtils.randomInteger(0, 5) == 0) {
                e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.WITHER_ROSE));
            }
        }
    }

    private boolean hasAllFlowers(Player player) {
        if (flowersByPlayer.get(player).size() != FLOWERS.size()) {
            return false;
        }

        for (Material flower : FLOWERS) {
            if (!flowersByPlayer.get(player).contains(flower)) {
                return false;
            }
        }

        return true;
    }
}
