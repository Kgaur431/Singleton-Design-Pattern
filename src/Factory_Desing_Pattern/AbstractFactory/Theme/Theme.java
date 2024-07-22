package Factory_Desing_Pattern.AbstractFactory.Theme;

public abstract class Theme {
    private String name;
    private String primaryColour;
    private String authorName;

    public abstract ThemeComponentFactory createComponentFactory();             // we can't implement this method here, becoz this method is diff for DarkTheme factory class & for PrimaryTheme factory class.
}
