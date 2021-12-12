package GSONClasses;

import java.util.List;

public class Move {
    String name;
    String url;
    List<VersionGroupDetail> version_group_details;

    public Move(){
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

    public List<VersionGroupDetail> getVersion_group_details() {
        return version_group_details;
    }

    public void setVersion_group_details(List<VersionGroupDetail> version_group_details) {
        this.version_group_details = version_group_details;
    }
}
