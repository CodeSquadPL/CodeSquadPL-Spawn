package mc.codesquadpl.codesquadplspawn;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private main _plugin;

    public SetSpawnCommand(main plg) {
        this._plugin = plg;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage(ColorUtil.colorize("&cOnly for players!"));
            return false;
        }

        Player p = (Player) commandSender;

        if(!p.hasPermission("codesquadpl-spawn.set")) {
            p.sendMessage(ColorUtil.colorize(_plugin.getConfig().getString("no_permission")));
            return false;
        }

        Location set_loc = p.getLocation();

        _plugin.getConfig().set("spawn_x", set_loc.getX());
        _plugin.getConfig().set("spawn_y", set_loc.getY());
        _plugin.getConfig().set("spawn_z", set_loc.getZ());

        _plugin.saveConfig();
        _plugin.reloadConfig();

        p.sendMessage(ColorUtil.colorize(_plugin.getConfig().getString("change_spawn").replace("{X}", Double.toString(set_loc.getX())).replace("{Y}", Double.toString(set_loc.getY())).replace("{Z}", Double.toString(set_loc.getZ()))));

        return false;
    }
}
