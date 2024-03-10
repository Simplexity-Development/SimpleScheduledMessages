package simplexity.simplescheduledmessages;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import simplexity.simplescheduledmessages.configs.ConfigHandler;
import simplexity.simplescheduledmessages.configs.LocaleHandler;

import java.util.ArrayList;

public class SchedulerManager {
    private BukkitTask task;
    private boolean paused;
    private int messageIndex;
    private final ArrayList<String> messages = ConfigHandler.getScheduledMessages();
    
    private SchedulerManager() {
    }
    
    private static SchedulerManager instance;
    
    public static SchedulerManager getInstance() {
        if (instance == null) {
            instance = new SchedulerManager();
        }
        return instance;
    }
    
    public void startScheduler() {
        BukkitScheduler scheduler = SimpleScheduledMessages.getInstance().getServer().getScheduler();
        if (task != null && !task.isCancelled()) task.cancel();
        task = scheduler.runTaskTimer(SimpleScheduledMessages.getInstance(), this::displayMessage, 0L,
                (ConfigHandler.getDelayTime() * 20L));
    }
    
    private void displayMessage() {
        if (!paused) {
            if ((messageIndex + 1) > messages.size()) messageIndex = 0;
            DisplayMessage.displayMessage((LocaleHandler.getInstance().getMessagePrefix()) + messages.get(messageIndex));
            messageIndex = messageIndex + 1;
        }
    }
    
    public void pauseScheduler() {
        paused = true;
    }
    
    public void resumeScheduler() {
        paused = false;
    }
    
    public boolean isPaused(){
        return paused;
    }
    
    
}
