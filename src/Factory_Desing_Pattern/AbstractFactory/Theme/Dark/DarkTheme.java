package Factory_Desing_Pattern.AbstractFactory.Theme.Dark;

import Factory_Desing_Pattern.AbstractFactory.Theme.Theme;
import Factory_Desing_Pattern.AbstractFactory.Theme.ThemeComponentFactory;

public class DarkTheme extends Theme {
    @Override
    public ThemeComponentFactory createComponentFactory() {
        return new DarkThemeFactory();
    }
}
