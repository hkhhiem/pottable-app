package tpp.pottable.navtab.DatabaseTab;

public class CatRecyclerViewItem {

    // Save category name.
    private String Name;

    // Save category image resource id.
    private int ImageId;

    // Save category description.
    private String Desc;

    public CatRecyclerViewItem(String Name, int ImageId, String Desc) {
        this.Name = Name;
        this.ImageId = ImageId;
        this.Desc = Desc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int ImageId) {
        this.ImageId = ImageId;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

}
