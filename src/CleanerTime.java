import java.util.Date;

public final class CleanerTime {
    private Cleaner cleaner;
    private Date date;

    public CleanerTime(Cleaner cleaner, Date date) {
        this.cleaner = cleaner;
        this.date = date;
    }

    public Cleaner getCleaner() {
        return cleaner;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return this.cleaner.getName() + " works on " + this.date.toString() + "\n";
    }
}
