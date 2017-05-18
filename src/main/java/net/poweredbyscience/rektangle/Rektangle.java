package net.poweredbyscience.rektangle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rektangle extends JavaPlugin implements Listener {

    static Rektangle plugin;
    Random r = new Random();
    List<String> rekts;

    public static Plugin getPlugin() {
        JavaPlugin plugin = Rektangle.plugin;
        return plugin;
    }

    public void onEnable() {
        rekts = loadRekts();
        reloadConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }
    
    public String getRekt() {
    	Integer rekt = r.nextInt(rekts.size());
    	return rekts.get(rekt);
    }

    public List loadRekts() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getClassLoader().getResourceAsStream("rekts.txt"), "UTF-8"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            return lines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
