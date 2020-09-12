import java.util.ArrayList;

public final class Gym {
    private StaffService staffService;
    private Owner owner;
    private ArrayList<Client> clients;
    private GoodsService goodsService;
    private boolean open;
    private SheduleService sheduleService;

    public Gym(StaffService stuff, Owner owner, ArrayList<Client> clients, GoodsService goods, boolean open, SheduleService sheduleService) {
        this.staffService = stuff;
        this.owner = owner;
        this.clients = clients;
        this.goodsService = goods;
        this.open = open;
        this.sheduleService = sheduleService;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public Owner getOwner() {
        return owner;
    }

    public SheduleService getSheduleService() {
        return sheduleService;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

    public String toString() {
        return "Clients: " + this.clients + "\n" + "Owner: " + this.owner + "\n" + "Goods: " + this.goodsService + "\n" + "Opened?: " + this.open + "\n" + "Shedule: " + this.sheduleService + "\n" + "Stuff: " + this.staffService;
    }

}
