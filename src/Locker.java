public final class Locker {
    private final int number;
    private boolean free = true;

    public Locker(int number) {
        this.number = number;
    }

    public void setFree() {
        this.free = true;
    }

    public void setNotFree(){
        this.free=false;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return "Locker number: " + this.number + " is free?: " + this.free + "\n";
    }
}
