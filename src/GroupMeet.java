import java.util.ArrayList;
import java.util.Date;

public final class GroupMeet {
    private ArrayList<Client> clients;
    private Trainer trainer;
    private Date date;
    private final int maxClients;

    public GroupMeet(Trainer trainer, Date date, int maxClients) {
        this.clients = new ArrayList<Client>();
        this.trainer = trainer;
        this.date = date;
        this.maxClients = maxClients;
    }

    public void addClient(Client client){
        this.clients.add(client);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        String s = "";
        for (Client client : clients) {
            s += client.toString() + "\n";

        }
        return "GroupMeeting with " + this.trainer + " max participants: " + this.maxClients + " Date: " + this.date.toString() + "\nparticipants:\n" + s;
    }

}
