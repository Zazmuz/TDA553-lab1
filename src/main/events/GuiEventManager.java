package main.events;

public class GuiEventManager extends EventManager {

    private static GuiEventManager instance;
    private GuiEventManager() {}

    public static GuiEventManager getInstance() {
        if (instance == null) instance = new GuiEventManager();
        return instance;
    }

}
