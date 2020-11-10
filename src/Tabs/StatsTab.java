package Tabs;

import javafx.scene.control.Tab;

public class StatsTab extends Tab {
    private static StatsTab instance = null;

    private StatsTab(){
        this.setText("Statistics");
    }

    public static StatsTab getInstance(){
        if(instance == null){
            instance = new StatsTab();
        }
        return instance;
    }
}
