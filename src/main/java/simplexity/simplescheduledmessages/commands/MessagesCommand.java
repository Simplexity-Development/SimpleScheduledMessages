package simplexity.simplescheduledmessages.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import simplexity.simplescheduledmessages.SchedulerManager;
import simplexity.simplescheduledmessages.SimpleScheduledMessages;
import simplexity.simplescheduledmessages.configs.LocaleHandler;

import java.util.List;

public class MessagesCommand implements TabExecutor {
    
    MiniMessage miniMessage = SimpleScheduledMessages.getMiniMessage();
    private final String pausedInsert = LocaleHandler.getInstance().getInsertPaused();
    private final String runningInsert = LocaleHandler.getInstance().getInsertRunning();
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        boolean paused = SchedulerManager.getInstance().isPaused();
        if (args.length == 0) {
            String state;
            if (paused) {
                state = pausedInsert;
            } else {
                state = runningInsert;
            }
            sender.sendMessage(miniMessage.deserialize(LocaleHandler.getInstance().getPauseState(),
                    Placeholder.parsed("state", state)));
            return true;
        }
        if (args[0].equalsIgnoreCase("toggle")) {
            if (paused) {
                SchedulerManager.getInstance().resumeScheduler();
                sender.sendRichMessage(LocaleHandler.getInstance().getResumed());
                return true;
            } else {
                SchedulerManager.getInstance().pauseScheduler();
                sender.sendRichMessage(LocaleHandler.getInstance().getPaused());
                return true;
            }
        }
        sender.sendRichMessage(LocaleHandler.getInstance().getUnknownCommand());
        return false;
    }
    
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length <= 1) {
            return List.of("toggle");
        }
        return List.of("");
    }
}
