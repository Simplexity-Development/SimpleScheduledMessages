package simplexity.simplescheduledmessages.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import simplexity.simplescheduledmessages.DisplayMessage;
import simplexity.simplescheduledmessages.configs.LocaleHandler;

import java.util.List;

public class BroadcastMsg implements TabExecutor {
    
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendRichMessage(LocaleHandler.getInstance().getProvideMessage());
            return false;
        }
        StringBuilder messageBuilder = new StringBuilder();
        for (String arg : args) {
            messageBuilder.append(arg).append(" ");
        }
        String messageToSend = messageBuilder.toString();
        DisplayMessage.displayMessage(LocaleHandler.getInstance().getBroadcastPrefix() + messageToSend);
        return true;
    }
    
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return List.of("");
    }
}
