package Factory_Desing_Pattern.AbstractFactory.Theme;

public interface ThemeComponentFactory {                // abstract factory                 it is able to create multiple objects of the same family (Theme).
    Button createButton();      // factory methods.
    Menu createMenu();
}
