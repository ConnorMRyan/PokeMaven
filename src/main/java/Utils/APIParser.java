package Utils;

import GSONClasses.Move.Move;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class APIParser {
    OkHttpClient client = new OkHttpClient();
    GsonBuilder builder = new GsonBuilder()
            .setPrettyPrinting();
    Gson gson = builder.create();


    public String getAMonster(String mon) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + mon;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            //pkmn = gson.fromJson(response.body().string(),Pokemon.class);
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getAMove(String move) throws Exception {
        String url = "https://pokeapi.co/api/v2/move/" + move;
        Move newMove;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            newMove = gson.fromJson(response.body().string(), Move.class);
            return gson.toJson(newMove);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
