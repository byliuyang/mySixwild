package application.Models.Badges;

import application.Models.Unlockable;
import application.Views.Application;

import java.awt.*;

/**
 *
 */
public abstract class Badge extends Unlockable {

    String name;

    String introduction;

    Image icon;

    public Badge(boolean unlockState) {
        super(unlockState);
    }

    public Badge(boolean unlockState, String name, String introduction, Image icon) {
        super(unlockState);
        this.name = name;
        this.introduction = introduction;
        this.icon = icon;
    }

    public abstract boolean isValid(Application app);

    public boolean takeBadge(Application app) {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }
}