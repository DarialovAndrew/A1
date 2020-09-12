import java.util.ArrayList;

public final class GoodsService {
    private final ArrayList<Locker> lockers;
    private final ArrayList<Shower> showers;
    private final ArrayList<Apparatus> apparatuses;

    public GoodsService() {
        this.lockers = new ArrayList<Locker>();
        this.showers = new ArrayList<Shower>();
        this.apparatuses = new ArrayList<Apparatus>();
    }

    public ArrayList<Apparatus> getApparatuses() {
        return apparatuses;
    }

    public ArrayList<Locker> getLockers() {
        return lockers;
    }

    public ArrayList<Shower> getShowers() {
        return showers;
    }

    public void add(Object thing){
        if(thing instanceof Locker){
            this.lockers.add((Locker)thing);
        }
        else if(thing instanceof Shower){
            this.showers.add((Shower)thing);
        }
        else this.apparatuses.add((Apparatus)thing);
    }

    public void delete(Object thing){
        if(thing instanceof Locker){
            this.lockers.remove((Locker)thing);
        }
        else if(thing instanceof Shower){
            this.showers.remove((Shower)thing);
        }
        else this.apparatuses.remove((Apparatus)thing);
    }

    public String toString() {
        return "Lockers: " + lockers.toString() + "\nShowers: " + this.showers.toString() + "\nApparatuses: " + this.apparatuses.toString() + "\n";
    }
}
