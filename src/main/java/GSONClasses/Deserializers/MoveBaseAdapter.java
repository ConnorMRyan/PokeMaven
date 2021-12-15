package GSONClasses.Deserializers;

import ActionStuff.Move.MoveBase;
import com.google.gson.*;

import java.lang.reflect.Type;

public class MoveBaseAdapter implements JsonDeserializer<MoveBase>, JsonSerializer<MoveBase> {
    private static final String CLASS_META_KEY = "CLASS_META_KEY";

    @Override
    public JsonElement serialize(MoveBase src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));

        return result;
    }

    @Override
    public MoveBase deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("properties");

        try {
            return context.deserialize(element, Class.forName("ActionStuff.Move." + type));
        } catch (ClassNotFoundException cnfe) {
            throw new JsonParseException("Unknown element type: " + type, cnfe);
        }
    }
}
