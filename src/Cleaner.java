public final class Cleaner {
    private final String name;
    private int salary;

    public Cleaner(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void clean() {
        System.out.println(this.name + " I am cleaning ");
    }

    public String toString() {
        return this.name + " has salary: " + this.salary + "\n";
    }
}
