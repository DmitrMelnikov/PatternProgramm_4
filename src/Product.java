public class Product {
    private String name;
    private int price;
    private int count;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getCount() {
        return this.count;
    }

    public Product setCount(int count) {
        this.count += count;
        return this;
    }

    public int getPrice() {
        return this.price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
