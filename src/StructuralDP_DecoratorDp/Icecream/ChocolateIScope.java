package StructuralDP_DecoratorDp.Icecream;

public class ChocolateIScope implements Icecream{

    private Icecream icecream;
    public ChocolateIScope(Icecream icecream){
        this.icecream = icecream;
    }
    @Override
    public int getCost() {
        return this.icecream.getCost() + 20;
    }

    @Override
    public String getConstituents() {
        return this.icecream.getConstituents() + "  "+ "Chocolate";
    }
}
