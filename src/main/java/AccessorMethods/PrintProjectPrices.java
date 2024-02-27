package AccessorMethods;

public class PrintProjectPrices {
    String name;
    int salary;

    public PrintProjectPrices() {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "PrintProjectPrices{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
