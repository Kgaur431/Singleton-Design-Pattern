package StructuralDP_DecoratorDp.Icecream;

public class BlueCone implements Icecream{
    @Override
    public int getCost() {
        return 10;
    }

    @Override
    public String getConstituents() {
        return "Blue Cone";
    }
}
