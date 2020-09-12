import java.util.ArrayList;

public final class SheduleService {
    private ArrayList<CleanerTime> cleanerTimes;
    private ArrayList<TrainerMeet> trainerMeets;
    private ArrayList<GroupMeet> groupMeets;

    public SheduleService() {
        this.cleanerTimes = new ArrayList<CleanerTime>();
        this.trainerMeets = new ArrayList<TrainerMeet>();
        this.groupMeets = new ArrayList<GroupMeet>();
    }

    public ArrayList<CleanerTime> getCleanerTimes() {
        return cleanerTimes;
    }

    public ArrayList<TrainerMeet> getTrainerMeets() {
        return trainerMeets;
    }

    public ArrayList<GroupMeet> getGroupMeets() {
        return groupMeets;
    }

    public void add(Object time){
        if(time instanceof CleanerTime){
            this.cleanerTimes.add((CleanerTime)time);
        }
        else if(time instanceof TrainerMeet){
            this.trainerMeets.add((TrainerMeet) time);
        }
        else this.groupMeets.add((GroupMeet)time);
    }

    public void delete(Object time){
        if(time instanceof CleanerTime){
            this.cleanerTimes.remove((CleanerTime)time);
        }
        else if(time instanceof TrainerMeet){
            this.trainerMeets.remove((TrainerMeet) time);
        }
        else this.groupMeets.remove((GroupMeet)time);
    }
    public String toString() {
        return "\nGroupMeetings: " + this.groupMeets.toString() + "\nTrainerMeetings: " + this.trainerMeets.toString() + "\nCleanerTime: " + this.cleanerTimes.toString() + "\n";
    }

}
