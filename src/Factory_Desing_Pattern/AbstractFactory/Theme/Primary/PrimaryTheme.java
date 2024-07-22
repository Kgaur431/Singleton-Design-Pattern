package Factory_Desing_Pattern.AbstractFactory.Theme.Primary;

import Factory_Desing_Pattern.AbstractFactory.Theme.Theme;
import Factory_Desing_Pattern.AbstractFactory.Theme.ThemeComponentFactory;

public class PrimaryTheme extends Theme {
    @Override
    public ThemeComponentFactory createComponentFactory() {
        return new PrimaryThemeFactory();
    }
}
