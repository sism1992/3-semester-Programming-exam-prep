package Design_patterns.design_2.Decorator;

public class SimplePizza implements Pizza {


    @Override
    public String getDescription() {
        return "Pizza bottom";
    }

    @Override
    public int getPrice() {
        return 40;
    }
}
