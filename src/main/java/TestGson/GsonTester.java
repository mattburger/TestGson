package TestGson;

import TestGson.swQuotes.SwResponse;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


class GsonTester {

    BufferedReader in;
    Gson g = new Gson();
    JsonResponse[] recentQuotes;
    JsonResponse swQuote;


    public GsonTester(String path) {
        try {
            this.in = new BufferedReader(new FileReader(path));

        } catch (Exception e) {
            throw new IllegalStateException("Can't read file that doesn't exist.");
        }
    }

    public void createResponseList(){
        this.recentQuotes = g.fromJson(this.in, JsonResponse[].class );
    }

    //path is location of the file you are writing quotes to
    public String getSwData(String path){
        try {
            URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            Gson gson = new Gson();

            BufferedReader reader = new BufferedReader(new InputStreamReader( con.getInputStream() ) );

            this.swQuote = gson.fromJson(reader, JsonResponse.class);
//            this.swJsonString = gson.toJson(this.swQuotes); //keep this for later testing

            BufferedReader reader2 = new BufferedReader((new FileReader(path)));
            List<JsonResponse> responses = gson.fromJson(reader2, new TypeToken<List>() {}.getType());
            if(!responses.contains(this.swQuote)) {
                responses.add(this.swQuote);
                String jsonResponses = gson.toJson(responses);

                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                writer.newLine();
                writer.write(jsonResponses);
                writer.close();
                reader.close();
                reader2.close();
            }

            return swQuote.getStarWarsQuote();

        } catch (Exception e){
            return "Error handling Star Wars quotes.";
        }
    }

    public String printRandom(){
        int range = this.recentQuotes.length;
        int randInteger = (int)(Math.random() * range) + 1;
        return this.recentQuotes[randInteger].toString();
    }

    public JsonResponse[] getRecentQuotes(){
        return this.recentQuotes;
    }
}