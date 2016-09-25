package v1.forestapp.com.forestapp;

public class ItemObjectMonAbs {

    private String name;
    private String address;
    private int photoId;

    public ItemObjectMonAbs(String name, String address, int photoId) {
        this.name = name;
        this.address = address;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhotoId() {
        return photoId;
    }

}
