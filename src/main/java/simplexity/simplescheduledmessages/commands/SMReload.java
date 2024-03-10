package simplexity.simplescheduledmessages.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import simplexity.simplescheduledmessages.SchedulerManager;
import simplexity.simplescheduledmessages.SimpleScheduledMessages;
import simplexity.simplescheduledmessages.configs.ConfigHandler;
import simplexity.simplescheduledmessages.configs.LocaleHandler;

public class SMReload implements CommandExecutor {
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        SimpleScheduledMessages.getInstance().reloadConfig();
        ConfigHandler.updateConfigValues();
        LocaleHandler.getInstance().loadLocale();
        SchedulerManager.getInstance().startScheduler();
        sender.sendRichMessage(LocaleHandler.getInstance().getConfigReloaded());
        return true;
    }
}
