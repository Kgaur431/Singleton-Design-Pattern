package StructuralDP_DecoratorDp.Icecream;

public class OrangeCone implements Icecream{
    @Override
    public int getCost() {
        return 5;
    }

    @Override
    public String getConstituents() {
        return "Orange Cone";
    }
}
