package mc.codesquadpl.codesquadplspawn;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private main _plugin;

    public SpawnCommand(main main) {
        this._plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ColorUtil.colorize("&cOnly for players!"));
            return false;
        }

        Player p = (Player) commandSender;

        if(!p.hasPermission("codesquadpl-spawn.use")) {
            p.sendMessage(ColorUtil.colorize(_plugin.getConfig().getString("no_permission")));
            return false;
        }

        p.teleport(new Location(p.getWorld(), _plugin.getConfig().getDouble("spawn_x"), _plugin.getConfig().getDouble("spawn_y"), _plugin.getConfig().getDouble("spawn_z")));
        return false;
    }
}
