package GSONClasses;

import java.util.List;

public class HeldItem {
    Item item;
    List<VersionDetails> version_details;

    public HeldItem() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<VersionDetails> getVersion_details() {
        return version_details;
    }

    public void setVersion_details(List<VersionDetails> version_details) {
        this.version_details = version_details;
    }
}
