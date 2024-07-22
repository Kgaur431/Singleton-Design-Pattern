``` Steps in which we are creating the things.
1.  we created Theme package & it has Theme (abstract) class with base implementation. like:-   name, primaryColour, authorName. 
2.  we create the child class. like Button, Menu etc. that is abstract class.
3.  we create the ThemeComponentFactory class.  right now we don't have any attributes so we can convert it into interface. 
      3.1   this interface has methods called createButton(), createMenu() etc.         (by default these will return the parent class but actually they should return respective child class type object).
4.  we create the package called Primary, Dark.
      4.1     (Buttons are changing based on the theme) so we create the DarkButton, PrimaryButton which extends Button class.      
      4.2    (Menus are changing based on the theme) so we create the DarkMenu, PrimaryMenu which extends Menu class. 
5.  we create the child class for Theme. like PrimaryTheme, DarkTheme which extends the Theme class. 
                first do step6, then do step 5.1 & 5.2 etc.
     5.1    PrimaryTheme class will implements the createComponentFactory & it return the PrimaryThemeFactory object.
     5.1    DarkTheme class will implements the createComponentFactory & it return the DarkThemeFactory object.
6.  we create the createComponentFactory() in the Theme class (it will link the ThemeComponentFactory class to the Theme class). 
7.  we create the DarkThemeFactory, PrimaryThemeFactory class which implements ThemeComponentFactory class & override those methods. 
      7.1   those override methods createButton(), createMenu() will return the respective class type object.
               7.1.1    In DarkThemeFactory class, createButton() will return the DarkButton type object.   same with menu also.
               7.1.2    In PrimaryThemeFactory class, createButton() will return the PrimaryButton type object.   same with menu also.
```                                        