public class Employee {
    public String fullName;
    public float salary;

    public static void main(String[] args) {
        String employeesInfo = "[";
        Employee emp1 = new Employee();
        emp1.fullName = "Ivan Ivanov";
        emp1.salary = 20000.05f;

        Employee emp2 = new Employee();
        emp2.fullName = "Lady Gaga";
        emp2.salary = 1000000000.45f;

        Employee[] employees = new Employee[2];
        employees[0] = emp1;
        employees[1] = emp2;

        for (int i = 0; i < employees.length; i++) {

            if (i != employees.length - 1) {
                employeesInfo += "{fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "},";
            } else {
                employeesInfo += " {fullName: \"" + employees[i].fullName + "\", salary: " + employees[i].salary + "}]";
            }
        }
        System.out.println(employeesInfo);
    }
}
