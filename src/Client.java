public final class Client {
    private final String name;
    private boolean present;
    private final boolean VIP;

    public Client(String name, boolean present, boolean VIP) {
        this.name = name;
        this.present = present;
        this.VIP = VIP;
    }


    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public void work(Apparatus apparatus) {
        System.out.println(this.name + " I am working on: " + apparatus.getName());
        apparatus.setNotFree();
    }

    public void locker(Locker locker) {
        System.out.println("I am using locker: " + locker.getNumber());
    }

    public void shower(Shower shower) {
        System.out.println("I am using shower: " + shower.getNumber());
    }

    public void train() {
        System.out.println(this.name + " I am training");
    }

    public String toString() {
        return this.name + " present: " + this.present + " VIP: " + this.VIP + "\n";
    }
}
