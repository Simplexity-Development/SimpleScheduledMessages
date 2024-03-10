package simplexity.simplescheduledmessages;

public class DisplayMessage {
    
    public static void displayMessage(String message) {
        SimpleScheduledMessages.getInstance().getServer().sendMessage(SimpleScheduledMessages.getMiniMessage().deserialize(message));
    }

}
