package fr.peaceandcube.killthehippie.fullflowers;

import com.gmail.val59000mc.game.GameManager;
import com.gmail.val59000mc.game.GameState;
import fr.peaceandcube.killthehippie.Scenarios;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class FlowersCommand implements CommandExecutor, TabExecutor {
    private final Plugin plugin;

    public FlowersCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (GameManager.getGameManager().getScenarioManager().isEnabled(Scenarios.FULL_FLOWERS)) {
            if (GameManager.getGameManager().getGameState().equals(GameState.PLAYING) && sender instanceof Player player) {
                FlowersGui inv = new FlowersGui(player);
                inv.openInventory(player);
                Bukkit.getServer().getPluginManager().registerEvents(inv, this.plugin);
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<>();
    }
}
