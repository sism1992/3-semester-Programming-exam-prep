package Design_patterns.design_2.Decorator;

public class Pepperoni extends PizzaDecorator {

    private final Pizza pizza;

    public Pepperoni(Pizza pizza){
        this.pizza = pizza;
    }


    @Override
    public String getDescription() {
        return pizza.getDescription()+", Pepperoni";
    }

    @Override
    public int getPrice() {
        return pizza.getPrice() + 10;
    }
}