package simplexity.simplescheduledmessages.configs;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import simplexity.simplescheduledmessages.SimpleScheduledMessages;

import java.io.File;
import java.io.IOException;

public class LocaleHandler {
    
    private static LocaleHandler instance;
    private final String fileName = "locale.yml";
    private final File localeFile = new File(SimpleScheduledMessages.getInstance().getDataFolder(), fileName);
    private final FileConfiguration localeConfig = new YamlConfiguration();
    
    // --------------------------------
    private String pauseState, paused, resumed, configReloaded;
    private String insertPaused, insertRunning, broadcastPrefix, messagePrefix;
    private String unknownCommand, provideMessage;
    
    private LocaleHandler() {
        if (!localeFile.exists()) {
            SimpleScheduledMessages.getInstance().saveResource(fileName, false);
        }
    }
    
    public static LocaleHandler getInstance() {
        if (instance == null) instance = new LocaleHandler();
        return instance;
    }
    
    public FileConfiguration getLocaleConfig() {
        return localeConfig;
    }
    
    public void loadLocale() {
        try {
            localeConfig.load(localeFile);
        } catch (IOException | InvalidConfigurationException e) {
            SimpleScheduledMessages.getInstance().getLogger().severe("Error loading locale.yml");
            SimpleScheduledMessages.getInstance().getLogger().severe(e.getMessage());
        }
        pauseState = localeConfig.getString("command-feedback.pause-state");
        paused = localeConfig.getString("command-feedback.paused");
        resumed = localeConfig.getString("command-feedback.resumed");
        configReloaded = localeConfig.getString("command-feedback.config-reloaded");
        insertPaused = localeConfig.getString("inserts.paused");
        insertRunning = localeConfig.getString("inserts.running");
        broadcastPrefix = localeConfig.getString("inserts.broadcast-prefix");
        messagePrefix = localeConfig.getString("inserts.message-prefix");
        provideMessage = localeConfig.getString("errors.provide-message");
        unknownCommand = localeConfig.getString("errors.unknown-command");
    }
    
    public String getPauseState() {
        return pauseState;
    }
    
    public String getPaused() {
        return paused;
    }
    
    public String getResumed() {
        return resumed;
    }
    
    public String getConfigReloaded() {
        return configReloaded;
    }
    
    public String getInsertPaused() {
        return insertPaused;
    }
    
    public String getInsertRunning() {
        return insertRunning;
    }
    
    public String getUnknownCommand() {
        return unknownCommand;
    }
    
    public String getBroadcastPrefix() {
        return broadcastPrefix;
    }
    
    public String getMessagePrefix() {
        return messagePrefix;
    }
    
    public String getProvideMessage() {
        return provideMessage;
    }
}
