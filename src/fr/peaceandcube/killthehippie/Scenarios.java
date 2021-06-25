package fr.peaceandcube.killthehippie;

import com.gmail.val59000mc.scenarios.Scenario;
import fr.peaceandcube.killthehippie.scenariolisteners.FoodStartListener;
import fr.peaceandcube.killthehippie.scenariolisteners.FullFlowersListener;
import fr.peaceandcube.killthehippie.scenariolisteners.NetheriteLessListener;
import org.bukkit.Material;

import java.util.List;

public class Scenarios {
    public static final Scenario FOOD_START = new Scenario("food_start", Material.COOKED_BEEF, FoodStartListener.class);
    public static final Scenario FULL_FLOWERS = new Scenario("full_flowers", Material.POPPY, FullFlowersListener.class);
    public static final Scenario NETHERITE_LESS = new Scenario("netherite_less", Material.NETHERITE_INGOT, NetheriteLessListener.class);

    public static void init() {
        FOOD_START.setInfo(new Scenario.Info("FoodStart", List.of("Tu démarres la partie avec 10 steaks.")));
        FULL_FLOWERS.setInfo(new Scenario.Info("FullFlowers", List.of(
                "Tu as pour objectif de récolter toutes les fleurs du jeu.",
                "Une fois cet objectif rempli, tu obtiens 15 coeurs jusqu'à la fin de la partie, peu importe ta vie restante.",
                "Les wither squelettes ont 1 chance sur 5 de donner des wither roses.",
                "La commande /flowers permet de voir ton avancée."
        )));
        NETHERITE_LESS.setInfo(new Scenario.Info("NetheriteLess", List.of("Tu ne peux pas obtenir d'objets en netherite.")));
    }
}
