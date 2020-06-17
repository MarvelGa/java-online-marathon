//часу не хватило допрацювати

public class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getBasePayment() {
        return basePayment;
    }

    @Override
    public String toString() {
        return "Employee[" +
                "name=" + name +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience &&
                Objects.equals(name, employee.name) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    @Override
    public BigDecimal getBasePayment() {
        return super.getBasePayment().multiply(BigDecimal.valueOf(coefficient).setScale(2));
    }

    @Override
    public String toString() {
        return "Manager[" +
                "name=" + getName() +
                ", experience=" + getExperience() +
                ", basePayment=" + getBasePayment() +
                ", coefficient=" + coefficient +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }
}


class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> newList = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();
        for (Employee e : workers) {
            if (e.getClass() == Manager.class) managers.add((Manager) e);
        }
        Employee maxExpEployee = workers.stream().max(new ExperienceComparator()).get();
        Employee maxPaymEployee = workers.stream().max(new PaymentComparator()).get();
        Manager maxExpMan = managers.stream().max(new ExperienceComparator()).get();
        Manager maxPaymMan = managers.stream().max(new PaymentComparator()).get();
        newList.add(maxExpEployee);
        if (maxExpEployee != maxPaymEployee) newList.add(maxPaymEployee);
        newList.add(maxExpMan);
        if (maxExpMan != maxPaymMan) newList.add(maxPaymMan);
        return newList;
    }
}

class ExperienceComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getExperience() > o2.getExperience()) {
            return -1;
        } else if (o1.getExperience() < o2.getExperience()) {
            return 1;
        }
        return o1.getName().compareTo(o2.getName());
    }
}

class PaymentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if( o1.getBasePayment().compareTo(o2.getBasePayment()) > 0){
            return 1;
        }
        else if( o1.getBasePayment().compareTo(o2.getBasePayment()) < 0){
            return -1;
        }
           return o1.getName().compareTo(o2.getName());
    }
}
