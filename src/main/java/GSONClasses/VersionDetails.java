package GSONClasses;

public class VersionDetails {
    int rarity;
    Version version;
    VersionDetails(){}

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
