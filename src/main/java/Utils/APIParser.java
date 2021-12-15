package Utils;

import GSONClasses.Move.Move;
import GSONClasses.Pokemon.Pokemon;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class APIParser {
    OkHttpClient client = new OkHttpClient();
    GsonBuilder builder = new GsonBuilder()
            .setPrettyPrinting();
    Gson gson = builder.create();
    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            return response.body().string();
        }
    }
    // Params
    //
    public String makeAMonster(String mon)throws Exception {
        String url = "https://pokeapi.co/api/v2/pokemon/" + mon;
        Pokemon pkmn;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
             pkmn = gson.fromJson(response.body().string(),Pokemon.class);

        }
        return gson.toJson(pkmn);

    }

    public String makeAMove(String move)throws Exception{
        String url = "https://pokeapi.co/api/v2/move/"+ move;
        Move newMove;
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            newMove = gson.fromJson(response.body().string(),Move.class);

        }
        return gson.toJson(newMove);
    }


}
