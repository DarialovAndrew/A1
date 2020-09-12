import java.util.ArrayList;

public final class StaffService {
    private ArrayList<Cleaner> cleaners;
    private ArrayList<Manager> managers;
    private ArrayList<Trainer> trainers;

    public StaffService() {
        this.cleaners = new ArrayList<Cleaner>();
        this.managers = new ArrayList<Manager>();
        this.trainers = new ArrayList<Trainer>();
    }

    public ArrayList<Cleaner> getCleaners() {
        return cleaners;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public void addStaff(Object worker){
        if(worker instanceof Cleaner){
            this.cleaners.add((Cleaner)worker);
        }
        else if(worker instanceof Manager){
            this.managers.add((Manager)worker);
        }
        else this.trainers.add((Trainer) worker);
    }

    public void deleteStaff(Object worker){
        if(worker instanceof Cleaner){
            this.cleaners.remove((Cleaner)worker);
        }
        else if(worker instanceof Manager){
            this.managers.remove((Manager) worker);
        }
        else this.trainers.remove((Trainer) worker);
    }

    public String toString() {
        return "\nCleaners: " + this.cleaners.toString() + "\nTrainers: " + this.trainers.toString() + "\nManagers: " + this.managers.toString() + "\n";
    }

}
