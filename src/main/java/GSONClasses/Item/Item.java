package GSONClasses.Item;

import GSONClasses.Game.VersionDetails;

public class Item {
    String name;
    String url;
    VersionDetails version_details;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public VersionDetails getVersion_details() {
        return version_details;
    }

    public void setVersion_details(VersionDetails version_details) {
        this.version_details = version_details;
    }
}
