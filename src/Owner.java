public final class Owner {
    private final String name;
    private int profit;

    public Owner(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }

    public void SayResults() {
        System.out.println("Current profit is:" + profit);
    }

    public void addMoney(int addition) {
        this.profit += addition;
    }

    public String toString() {
        return this.name + " has profit: " + this.profit + "\n";
    }
}
