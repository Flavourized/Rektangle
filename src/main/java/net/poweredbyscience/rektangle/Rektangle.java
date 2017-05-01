package net.poweredbyscience.rektangle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Rektangle extends JavaPlugin implements Listener {

    static Rektangle plugin;

    public static Plugin getPlugin() {
        JavaPlugin plugin = Rektangle.plugin;
        return plugin;
    }
	

    public static String[] rekts = {"☐ Not rekt","☑ Rekt","☑ Really Rekt","☑ Tyrannosaurus Rekt","☑ Cash4Rekt.com","☑ Grapes of Rekt","☑ Ship Rekt","☑ Rekt markes the spot","☑ Caught rekt handed","☑ The Rekt Side Story","☑ Singin' In The Rekt","☑ Painting The Roses Rekt","☑ Rekt Van Winkle","☑ Parks and Rekt","☑ Lord of the Rekts: The Reking of the King","☑ Star Trekt","☑ The Rekt Prince of Bel-Air","☑ A Game of Rekt","☑ Rektflix","☑ Rekt it like it's hot","☑ RektBox 360","☑ The Rekt-men","☑ School Of Rekt","☑ I am Fire, I am Rekt","☑ Rekt and Roll","☑ Professor Rekt","☑ Catcher in the Rekt","☑ Rekt-22","☑ Harry Potter: The Half-Rekt Prince","☑ Great Rektspectations","☑ Paper Scissors Rekt","☑ RektCraft","☑ Grand Rekt Auto V","☑ Call of Rekt: Modern Reking 2","☑ Legend Of Zelda: Ocarina of Rekt","☑ Rekt It Ralph","☑ Left 4 Rekt","☑ www.rekkit.com","☑ Pokemon: Fire Rekt","☑ The Shawshank Rektemption","☑ The Rektfather","☑ The Rekt Knight","☑ Fiddler on the Rekt","☑ The Rekt Files","☑ The Good, the Bad, and The Rekt","☑ Forrekt Gump","☑ The Silence of the Rekts","☑ The Green Rekt","☑ Gladirekt","☑ Spirekted Away","☑ Terminator 2: Rektment Day","☑ The Rekt Knight Rises","☑ The Rekt King","☑ REKT-E","☑ Citizen Rekt","☑ Requiem for a Rekt","☑ REKT TO REKT ass to ass","☑ Star Wars: Episode VI - Return of the Rekt","☑ Braverekt","☑ Batrekt Begins","☑ 2001: A Rekt Odyssey","☑ The Wolf of Rekt Street","☑ Rekt's Labyrinth","☑ 12 Years a Rekt","☑ Gravirekt","☑ Finding Rekt","☑ The Arekters","☑ There Will Be Rekt","☑ Christopher Rektellston","☑ Hachi: A Rekt Tale","☑ The Rekt Ultimatum","☑ Shrekt","☑ Rektal Exam","☑ Rektium for a Dream","☑ Erektile Dysfunction","☑ Rektified","☑ Rektrield"}; //hardcoded 4 suggestions

    public void onEnable() {
    	this.getConfig().addDefault("rekts", rekts);
    	this.getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }
    
    public String getRekt() {
    	Random r = new Random();
    	List<String> rekts = this.getConfig().getStringList("rekts");
    	Integer rekt = r.nextInt(rekts.size());
    	return rekts.get(rekt);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent ev) {
        if (ev.getMessage().startsWith("?rekt")) {
        	if (ev.getPlayer().hasPermission("rektangle.rekt") || ev.getPlayer().isOp()) {
        		new BukkitRunnable() {
        			@Override
        			public void run() {
        				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a" + ev.getPlayer().getName() + ": &b" + getRekt()));
        			}
        		}.runTaskLater(this,5);
        	}
        }
    }

}
