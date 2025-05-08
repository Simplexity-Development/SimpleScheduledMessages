package simplexity.simplescheduledmessages.configs;

import org.bukkit.configuration.file.FileConfiguration;
import simplexity.simplescheduledmessages.SimpleScheduledMessages;

import java.util.ArrayList;
import java.util.List;

public class ConfigHandler {
    private static final ArrayList<String> scheduledMessages = new ArrayList<>();
    private static int delayTime;

    public static void updateConfigValues() {
        FileConfiguration config = SimpleScheduledMessages.getInstance().getConfig();
        scheduledMessages.clear();
        List<String> messages = config.getStringList("messages-to-display");
        delayTime = config.getInt("delay-time");
        if (!messages.isEmpty()) {
            scheduledMessages.addAll(messages);
        }
    }

    public static ArrayList<String> getScheduledMessages() {
        return scheduledMessages;
    }

    public static int getDelayTime() {
        return delayTime;
    }
}
