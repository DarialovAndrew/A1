public final class Apparatus {
    private final String name;
    private int age;
    boolean free = true;

    public Apparatus(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void setFree() {
        this.free = true;
    }

    public String getName() {
        return name;
    }

    public void setNotFree() {
        this.free = false;
    }

    public String toString() {
        return this.name + " age: " + this.age + " is free?: " + this.free + "\n";
    }
}
