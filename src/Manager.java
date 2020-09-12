public final class Manager {
    private final String name;
    private int salary;

    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work() {
        System.out.println(this.name + " I am working ");
    }

    public String toString() {
        return this.name + " has salary: " + this.salary + "\n";
    }
}
