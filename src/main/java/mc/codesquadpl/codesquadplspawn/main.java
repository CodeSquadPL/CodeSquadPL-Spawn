package mc.codesquadpl.codesquadplspawn;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        reloadConfig();
        getLogger().info("Status: OK");
        Bukkit.getPluginManager().addPermission(new Permission("codesquadpl-spawn.use"));
        Bukkit.getPluginManager().addPermission(new Permission("codesquadpl-spawn.set"));

        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Status: STOP");
    }
}
