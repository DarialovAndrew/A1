public final class Trainer {
    private final String name;
    private final String status;

    public Trainer(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void work() {
        System.out.println(this.name + " I am working");
    }

    public String toString() {
        return this.name + " has status: " + this.status + "\n";
    }

}
