import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrinkReceipt {
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    Map<String, Integer> makeDrink();
}

interface Rating {
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients;

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public DrinkReceipt addComponent(String componentName, int componentCount) {
        return this;
    }

    public Map<String, Integer> makeDrink() {
        Map<String, Integer> list = new HashMap<String, Integer>();
        list.put("Water", 100);
        list.put("Arabica", 20);
        return list;
    }
}

class Espresso extends Caffee {

    public Espresso(String name, int rating) {
        super(name, rating);
    }

    @Override
    public String getName() {
        return "Espresso";
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> list = new HashMap<String, Integer>();
        list.put("Water", 50);
        list.put("Arabica", 20);
        return list;
    }

    @Override
    public String toString() {
        return "Espresso{}";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class Cappuccino extends Caffee {
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public String getName() {
        return "Cappuccino";
    }

    @Override
    public Map<String, Integer> makeDrink() {
        Map<String, Integer> list = new HashMap<String, Integer>();
        list.put("Water", 100);
        list.put("Arabica", 20);
        list.put("Milk", 50);
        return list;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {
        Map<String, Double> result = new HashMap<String, Double>();
        double caffeeRating = 0;
        double espressoRating = 0;
        double cappuccinoRating = 0;
        double caffeeAvRating = 0;
        double espressoAvRating = 0;
        double cappuccinoAvRating = 0;
        int i = 0;
        int j = 0;
        int z = 0;
        for (Caffee elem : coffees) {
            if (elem != null) {
                if (elem.getClass() == Caffee.class) {
                    i++;
                    caffeeRating += elem.getRating();
                }
                if (elem.getClass() == Espresso.class) {
                    j++;
                    espressoRating += elem.getRating();
                }
                if (elem.getClass() == Cappuccino.class) {
                    z++;
                    cappuccinoRating += elem.getRating();
                }
            }
        }
        if (i != 0) {
            caffeeAvRating = caffeeRating / i;
            result.put("Caffee", caffeeAvRating);
        }
        if (j != 0) {
            espressoAvRating = espressoRating / j;
            result.put("Espresso", espressoAvRating);
        }
        if (z != 0) {
            cappuccinoAvRating = cappuccinoRating / z;
            result.put("Cappuccino", cappuccinoAvRating);
        }
        return result;
    }
}
