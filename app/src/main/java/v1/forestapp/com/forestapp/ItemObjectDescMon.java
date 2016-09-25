package v1.forestapp.com.forestapp;

public class ItemObjectDescMon {

    private String item;
    private String desc;
    private String desc2;

    public ItemObjectDescMon(String item, String desc, String desc2) {
        this.item = item;
        this.desc = desc;
        this.desc2 = desc2;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public String getDesc2() {
        return desc2;
    }

}
