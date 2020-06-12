public class Product {
    private String name;
    private double price;

    private static int counter;

    public Product() {
        counter++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

  public static int count(){
        return counter;
    }

    public static void main(String[] args) {
        Product p1 = new Product("Pen",2.75);
        Product p2 = new Product();
        Product p3 = new Product("Notebook",8.25);
        int countOfProducts =Product.count();
        System.out.println("Was created "+ countOfProducts+ " new products!");
    }
}
