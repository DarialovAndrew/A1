
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Owner owner = owner();

        ArrayList<Cleaner> cleaners = cleaners();
        ArrayList<Trainer> trainers = trainers();
        ArrayList<Manager> managers = managers();
        StaffService staff = staffService(cleaners, trainers, managers);

        ArrayList<Client> clients = clients();

        ArrayList<Locker> lockers = lockers();
        ArrayList<Shower> showers = showers();
        ArrayList<Apparatus> apparatuses = Apparatuses();
        GoodsService goodsService = goodsService(showers, apparatuses, lockers);

        ArrayList<Date> date = dates();

        ArrayList<TrainerMeet> trainerMeets = trainerMeets(trainers, clients, date);
        ArrayList<CleanerTime> cleanerTimes = cleanerTimes(cleaners, date);
        ArrayList<GroupMeet> groupMeets = groupMeets(clients, trainers, date);
        SheduleService sheduleService = sheduleService(trainerMeets, cleanerTimes, groupMeets);

        Gym gym = new Gym(staff, owner, clients, goodsService, true, sheduleService);
        simulate(gym, date);
    }

    public static ArrayList<Apparatus> Apparatuses() {
        ArrayList<Apparatus> apparatuses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            apparatuses.add(new Apparatus("Barbell" + Integer.toString(i), i));
        }
        for (int i = 0; i < 5; i++) {
            apparatuses.add(new Apparatus("Arbitrack" + Integer.toString(i), i));
        }
        for (int i = 0; i < 5; i++) {
            apparatuses.add(new Apparatus("SpeedRunner" + Integer.toString(i), i));
        }
        for (int i = 0; i < 5; i++) {
            apparatuses.add(new Apparatus("Dumbbells" + Integer.toString(i), i));
        }
        return apparatuses;
    }

    public static ArrayList<GroupMeet> groupMeets(ArrayList<Client> clients, ArrayList<Trainer> trainers, ArrayList<Date> date) {
        ArrayList<GroupMeet> groupMeets = new ArrayList<>();
        for (int i = 0; i < 30; i += 2) {
            int j = (int) (Math.random() * 10);
            ArrayList<Client> clients1 = new ArrayList<>();
            while (clients1.size() != 15) {
                int q = (int) (Math.random() * 100);
                if (!clients1.contains(clients.get(q))) {
                    clients1.add(clients.get(q));
                }
            }
            groupMeets.add(new GroupMeet(clients1, trainers.get(j), date.get(i), 15));
        }
        return groupMeets;
    }

    public static void simulate(Gym gym, ArrayList<Date> date) {
        while (date.size() != 0) {
            Date date1 = date.get(0);
            System.out.println(date1);

            gym.getOwner().SayResults();

            shedulework(gym, date1);

            groupwork(gym, date1);


            ArrayList<Client> clients1 = randomClient(gym);

            ArrayList<Apparatus> apparatuses1 = randomApparat(gym);

            ArrayList<Shower> showers1 = randomShower(gym);

            ArrayList<Locker> lockers1 = randomLocker(gym);

            System.out.println("\n\nClients present at gym: \n");
            for (int i = 0; i < 15; i++) {
                clients1.get(i).work(apparatuses1.get(i));
                clients1.get(i).locker(lockers1.get(i));
                clients1.get(i).shower(showers1.get(i));
            }

            try {
                TimeUnit.SECONDS.sleep(30);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }

            System.out.println("\n\n");
            gym.getOwner().addMoney(gym.getClients().size() * 10);
            date.remove(0);

            delete(gym);

            add(gym);

            System.out.println("Next day");
            allfree(gym);
        }

    }

    public static void groupwork(Gym gym, Date date1) {
        System.out.println("\n\nGroupMeeting: ");
        for (GroupMeet groupMeet : gym.getSheduleService().getGroupMeets()) {
            if (groupMeet.getDate().equals(date1)) {
                groupMeet.getTrainer().work();
                System.out.println("Clients present at the meeting: \n");
                for (Client client : groupMeet.getClients()) {
                    System.out.println(client.getName() + "\n");
                    client.setPresent(true);
                }
            }
        }
    }

    public static void shedulework(Gym gym, Date date1) {
        System.out.println("Managers:");
        for (Manager manager : gym.getStaffService().getManagers()) {
            manager.work();
        }


        System.out.println("\n\nCleaners: ");
        for (CleanerTime cleanerTime : gym.getSheduleService().getCleanerTimes()) {
            if (cleanerTime.getDate().equals(date1)) {
                cleanerTime.getCleaner().clean();
            }
        }


        System.out.println("\n\nTrainerMeet:");
        for (TrainerMeet trainerMeet : gym.getSheduleService().getTrainerMeets()) {
            if (trainerMeet.getDate().equals(date1)) {
                trainerMeet.getTrainer().work();
                trainerMeet.getClient().train();
                trainerMeet.getClient().setPresent(true);
            }
        }
    }

    public static ArrayList<Client> randomClient(Gym gym) {
        ArrayList<Client> clients1 = new ArrayList<>();
        while (clients1.size() != 15) {
            int q = (int) (Math.random() * 100);
            if (!clients1.contains(gym.getClients().get(q))) {
                clients1.add(gym.getClients().get(q));
            }
        }
        return clients1;
    }

    public static ArrayList<Apparatus> randomApparat(Gym gym) {
        ArrayList<Apparatus> apparatuses1 = new ArrayList<>();
        while (apparatuses1.size() != 15) {
            int q = (int) (Math.random() * 20);
            if (!apparatuses1.contains(gym.getGoodsService().getApparatuses().get(q))) {
                apparatuses1.add(gym.getGoodsService().getApparatuses().get(q));
                gym.getGoodsService().getApparatuses().get(q).setNotFree();
            }
        }
        return apparatuses1;
    }

    public static ArrayList<Shower> randomShower(Gym gym) {
        ArrayList<Shower> showers1 = new ArrayList<>();
        while (showers1.size() != 15) {
            int q = (int) (Math.random() * 20);
            if (!showers1.contains(gym.getGoodsService().getShowers().get(q))) {
                showers1.add(gym.getGoodsService().getShowers().get(q));
                gym.getGoodsService().getShowers().get(q).setNotFree();
            }
        }
        return showers1;
    }

    public static ArrayList<Locker> randomLocker(Gym gym) {
        ArrayList<Locker> lockers1 = new ArrayList<>();
        while (lockers1.size() != 15) {
            int q = (int) (Math.random() * 30);
            if (!lockers1.contains(gym.getGoodsService().getLockers().get(q))) {
                lockers1.add(gym.getGoodsService().getLockers().get(q));
                gym.getGoodsService().getLockers().get(q).setNotFree();
            }
        }
        return lockers1;

    }

    public static void allfree(Gym gym) {
        for (Apparatus apparatus : gym.getGoodsService().getApparatuses()) {
            apparatus.setFree();
        }
        for (Shower shower : gym.getGoodsService().getShowers()) {
            shower.setFree();
        }
        for (Locker locker : gym.getGoodsService().getLockers()) {
            locker.setFree();
        }
    }

    public static void delete(Gym gym) {

        gym.getGoodsService().delete(gym.getGoodsService().getLockers().get(0));

        gym.getSheduleService().delete(gym.getSheduleService().getCleanerTimes().get(0));
        gym.getSheduleService().delete(gym.getSheduleService().getGroupMeets().get(0));
        gym.getSheduleService().delete(gym.getSheduleService().getTrainerMeets().get(0));


    }

    public static void add(Gym gym) {

        gym.getGoodsService().add(new Locker(0));

        int index = (int) (Math.random() * 5);
        int month = (int) (Math.random() * 12) + 1;
        int day = (int) (Math.random() * 28) + 1;

        gym.getSheduleService().add(new CleanerTime(gym.getStaffService().getCleaners().get(index), new Date(2020, month, day)));
    }

    public static Owner owner() {
        return new Owner("Owner", 0);
    }

    public static ArrayList<Cleaner> cleaners() {
        ArrayList<Cleaner> cleaners = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cleaners.add(new Cleaner("Cleaner" + Integer.toString(i), 1000));
        }
        return cleaners;
    }

    public static ArrayList<Trainer> trainers() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            trainers.add(new Trainer("Trainer" + Integer.toString(i), "Master"));
        }
        return trainers;
    }

    public static ArrayList<Manager> managers() {
        ArrayList<Manager> managers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            managers.add(new Manager("Manager" + Integer.toString(i), 5000));
        }
        return managers;
    }

    public static ArrayList<Client> clients() {
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            clients.add(new Client("Client" + Integer.toString(i), false, false));
        }
        return clients;
    }

    public static ArrayList<Locker> lockers() {
        ArrayList<Locker> lockers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            lockers.add(new Locker(i));
        }
        return lockers;
    }

    public static ArrayList<Shower> showers() {
        ArrayList<Shower> showers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            showers.add(new Shower(i, true));
        }
        return showers;
    }

    public static ArrayList<Date> dates() {
        ArrayList<Date> date = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            date.add(new Date(2020, Calendar.SEPTEMBER, i + 1));
        }
        return date;
    }

    public static ArrayList<TrainerMeet> trainerMeets(ArrayList<Trainer> trainers, ArrayList<Client> clients, ArrayList<Date> date) {
        ArrayList<TrainerMeet> trainerMeets = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int j = (int) (Math.random() * 10);
            int k = (int) (Math.random() * 100);
            trainerMeets.add(new TrainerMeet(trainers.get(j), clients.get(k), date.get(i)));
        }
        return trainerMeets;
    }

    public static ArrayList<CleanerTime> cleanerTimes(ArrayList<Cleaner> cleaners, ArrayList<Date> date) {
        ArrayList<CleanerTime> cleanerTimes = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int j = (int) (Math.random() * 5);
            cleanerTimes.add(new CleanerTime(cleaners.get(j), date.get(i)));
        }
        return cleanerTimes;
    }

    public static StaffService staffService(ArrayList<Cleaner> cleaners, ArrayList<Trainer> trainers, ArrayList<Manager> managers) {
        StaffService staffService = new StaffService();
        for (Cleaner cleaner : cleaners) {
            staffService.addStaff(cleaner);
        }
        for (Manager manager : managers) {
            staffService.addStaff(manager);
        }
        for (Trainer trainer : trainers) {
            staffService.addStaff(trainer);
        }
        return staffService;
    }

    public static GoodsService goodsService(ArrayList<Shower> showers, ArrayList<Apparatus> apparatuses, ArrayList<Locker> lockers) {
        GoodsService goodsService = new GoodsService();
        for (Shower shower : showers) {
            goodsService.add(shower);
        }
        for (Apparatus apparatus : apparatuses) {
            goodsService.add(apparatus);
        }
        for (Locker locker : lockers) {
            goodsService.add(locker);
        }
        return goodsService;
    }

    public static SheduleService sheduleService(ArrayList<TrainerMeet> trainerMeets, ArrayList<CleanerTime> cleanerTimes, ArrayList<GroupMeet> groupMeets) {
        SheduleService sheduleService = new SheduleService();
        for (TrainerMeet trainerMeet : trainerMeets) {
            sheduleService.add(trainerMeet);
        }
        for (CleanerTime cleanerTime : cleanerTimes) {
            sheduleService.add(cleanerTime);
        }
        for (GroupMeet groupMeet : groupMeets) {
            sheduleService.add(groupMeet);
        }
        return sheduleService;
    }

}