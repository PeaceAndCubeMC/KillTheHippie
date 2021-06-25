package fr.peaceandcube.killthehippie;

import com.gmail.val59000mc.game.GameManager;
import com.gmail.val59000mc.scenarios.ScenarioManager;
import fr.peaceandcube.killthehippie.fullflowers.FlowersCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KillTheHippie extends JavaPlugin {

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("UhcCore")) {
            final ScenarioManager scenarioManager = GameManager.getGameManager().getScenarioManager();

            Scenarios.init();

            scenarioManager.registerScenario(Scenarios.FOOD_START);
            scenarioManager.registerScenario(Scenarios.FULL_FLOWERS);
            scenarioManager.registerScenario(Scenarios.NETHERITE_LESS);

            this.getCommand("flowers").setExecutor(new FlowersCommand(this));
        }
    }
}
