import java.util.Date;

public final class TrainerMeet {
    private Trainer trainer;
    private Client client;
    private Date date;

    public TrainerMeet(Trainer trainer, Client client, Date date) {
        this.trainer = trainer;
        this.client = client;
        this.date = date;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return "Meeting : " + this.trainer.getName() + " with " + this.client.getName() + "Date: " + this.date + "\n";
    }
}
