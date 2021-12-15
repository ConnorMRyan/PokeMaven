package GSONClasses.Pokemon;

import com.google.gson.annotations.Expose;

public class MetaType {
    @Expose
    int slot;
    @Expose
    Type type;

    public MetaType() {
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
