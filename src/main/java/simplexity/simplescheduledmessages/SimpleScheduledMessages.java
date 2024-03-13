package simplexity.simplescheduledmessages;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;
import simplexity.simplescheduledmessages.commands.BroadcastMsg;
import simplexity.simplescheduledmessages.commands.AutoMessage;
import simplexity.simplescheduledmessages.commands.SMReload;
import simplexity.simplescheduledmessages.configs.ConfigHandler;
import simplexity.simplescheduledmessages.configs.LocaleHandler;

public final class SimpleScheduledMessages extends JavaPlugin {
    
    private static SimpleScheduledMessages instance;
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        ConfigHandler.updateConfigValues();
        LocaleHandler.getInstance().loadLocale();
        SchedulerManager.getInstance().startScheduler();
        this.getCommand("smreload").setExecutor(new SMReload());
        this.getCommand("automessage").setExecutor(new AutoMessage());
        this.getCommand("broadcastmsg").setExecutor(new BroadcastMsg());
    }
    
    public static SimpleScheduledMessages getInstance() {
        return instance;
    }
    
    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }
    
}
