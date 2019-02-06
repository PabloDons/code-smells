package nerdschool.bar;

public class SimpleBeverage implements Beverage {
    String name;
    int price;

    public SimpleBeverage(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean hasUpperLimit() {
        return false;
    }

    @Override
    public boolean hasStudentDiscount() {
        return true;
    }


}
