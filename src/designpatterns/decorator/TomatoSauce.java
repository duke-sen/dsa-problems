package designpatterns.decorator;

public class TomatoSauce extends ToppingDecorator{

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Sauce");
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tomato Sauce";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.35;
    }
}
