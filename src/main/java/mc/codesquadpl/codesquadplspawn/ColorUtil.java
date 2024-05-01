package mc.codesquadpl.codesquadplspawn;

import org.bukkit.ChatColor;

public class ColorUtil {
    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
