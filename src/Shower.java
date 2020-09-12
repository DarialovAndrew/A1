public final class Shower {
    private final int number;
    private boolean free;

    public Shower(int number, boolean free) {
        this.number = number;
        this.free = free;
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
        return "Shower number: " + this.number + " is free?: " + this.free + "\n";
    }
}
