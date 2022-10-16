package com.sirisuk.sk_lobbypvp;


import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {


    private static Main plugin;
    private Listeners listeners;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getServer().getConsoleSender().sendMessage(format("&a" + getDescription().getName() + " v" + getDescription().getVersion() + " enabled."));

        listeners = new Listeners();
        getServer().getPluginManager().registerEvents(listeners, this);

        getCommand("pvp").setExecutor(new PluginCommand());
        getCommand("pvp").setTabCompleter(new PluginCommand());

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        listeners.pvpTask.clear();
        listeners.pvpTask2.clear();
        listeners.pvp.clear();
        listeners.flying.clear();
        getServer().getConsoleSender().sendMessage(format("&c" + getDescription().getName() + " v" + getDescription().getVersion() + " disabled."));
    }

    public static Main getPlugin() {
        return plugin;
    }

    public String format(String text) {
        return text.replaceAll("&", "§");
    }

}
