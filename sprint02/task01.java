public class Person {
    int age;
    String name;
    String healthInfo;
    String getHealthStatus(){ return name +" " + healthInfo; }
    
    public Person(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }
}

class Child extends Person{
    String childIDNumber;

    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }
}

class Adult extends Person{
    String passportNumber;
    
    public Adult(int age, String name, String healthInfo, String passportNumber) {
        super(age, name, healthInfo);
        this.passportNumber = passportNumber;
    }
}
