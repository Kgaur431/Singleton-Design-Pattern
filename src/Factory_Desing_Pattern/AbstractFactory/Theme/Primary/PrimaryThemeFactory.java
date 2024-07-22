package Factory_Desing_Pattern.AbstractFactory.Theme.Primary;


import Factory_Desing_Pattern.AbstractFactory.Theme.ThemeComponentFactory;

public class PrimaryThemeFactory implements ThemeComponentFactory {
    @Override
    public PrimaryButton createButton() {
        return new PrimaryButton();
    }

    @Override
    public PrimaryMenu createMenu() {
        return new PrimaryMenu();
    }
}
