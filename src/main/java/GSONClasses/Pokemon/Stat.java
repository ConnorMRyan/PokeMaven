package GSONClasses.Pokemon;

import com.google.gson.annotations.Expose;

public class Stat {
    @Expose
    String name;
    String url;

    public Stat() {
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
}
