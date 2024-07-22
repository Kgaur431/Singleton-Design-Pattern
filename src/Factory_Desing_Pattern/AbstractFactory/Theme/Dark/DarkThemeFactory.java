package Factory_Desing_Pattern.AbstractFactory.Theme.Dark;

import Factory_Desing_Pattern.AbstractFactory.Theme.ThemeComponentFactory;

public class DarkThemeFactory implements ThemeComponentFactory {
    @Override
    public DarkButton createButton() {
        return new DarkButton();
    }

    @Override
    public DarkMenu createMenu() {
        return new DarkMenu();
    }
}
