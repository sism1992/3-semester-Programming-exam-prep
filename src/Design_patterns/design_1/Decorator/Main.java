package Design_patterns.design_1.Decorator;

public class Main {
    //https://www.javacodegeeks.com/2015/09/decorator-design-pattern.html

    public static void main(String[] args) {

        Pizza pizza = new SimplePizza();
        
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());
        System.out.println(pizza);


        pizza = new TomatoSauce(pizza);
        pizza = new Cheese(pizza);
        pizza = new Pepperoni(pizza);


        System.out.println(pizza.getDescription());
        System.out.println(pizza.getPrice());
        System.out.println(pizza);


    }
}
