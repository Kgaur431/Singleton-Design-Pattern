package Factory_Desing_Pattern.AbstractFactory;

import Factory_Desing_Pattern.AbstractFactory.Theme.Button;
import Factory_Desing_Pattern.AbstractFactory.Theme.Menu;
import Factory_Desing_Pattern.AbstractFactory.Theme.Primary.PrimaryTheme;
import Factory_Desing_Pattern.AbstractFactory.Theme.Theme;
import Factory_Desing_Pattern.AbstractFactory.Theme.ThemeComponentFactory;

public class Main {
    public static void main(String[] args) {
        // just for example we are using Primary Theme.
        Theme primary = new PrimaryTheme();
        // How we can create the component factory for the primary theme
        ThemeComponentFactory primaryThemeComponentFactory = primary.createComponentFactory();
        // How can we create the Button.    we can create it by calling the factory method createButton() of PrimaryThemeFactory class.
        Button button = primaryThemeComponentFactory.createButton();
        Menu menu = primaryThemeComponentFactory.createMenu();

        // assume as per new requirments we want Dark Theme, dark button, dark menu etc.    ==>     so for that we just have to change this Theme primary = new PrimaryTheme();     to   Theme primary = new DarkTheme();
        // all the remaining code will work.

    }
}
