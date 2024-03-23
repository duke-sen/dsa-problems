package designpatterns.decorator;

public abstract class ToppingDecorator implements Pizza{
    private Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza) {
        this.tempPizza = newPizza;
    }

    public String getDescription() {
        return tempPizza.getDescription();
    }


    public double getCost() {
        return tempPizza.getCost();
    }
}
