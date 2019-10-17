package Design_patterns.design_2.Decorator;

public abstract class PizzaDecorator implements Pizza {

    @Override
    public String getDescription() {
        return "Toppings";
    }
}
