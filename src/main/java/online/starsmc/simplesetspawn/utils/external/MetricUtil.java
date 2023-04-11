package online.starsmc.simplesetspawn.utils.external;

import online.starsmc.simplesetspawn.Main;
import org.bstats.bukkit.Metrics;

public class MetricUtil {

    private final Main plugin;

    public MetricUtil(Main plugin) {
        this.plugin = plugin;
    }

    public void load() {
        this.metrics();
        plugin.getLogger().warning("Metrics enabled correctly.");
    }

    public void disable() {
        metrics().shutdown();
        plugin.getLogger().warning("Metrics disabled correctly.");
    }

    public Metrics metrics() {
        int pluginId = 18178;
        return new Metrics(plugin, pluginId);
    }
}
