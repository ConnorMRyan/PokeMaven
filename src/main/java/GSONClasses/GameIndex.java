package GSONClasses;

import jdk.nashorn.internal.runtime.Version;

public class GameIndex {
    int game_index;
    Version version;

    GameIndex(){
    }

    public int getGame_index() {
        return game_index;
    }

    public void setGame_index(int game_index) {
        this.game_index = game_index;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
