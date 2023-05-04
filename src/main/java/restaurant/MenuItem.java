package restaurant;

public class MenuItem {
    private int code;
    private String name;
    private double price;

    public MenuItem(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public MenuItem() {
    }



    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

}
