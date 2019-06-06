package TestGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;

class ParseJson{

    String line;
    String json;
    ArrayList<String> quotes = new ArrayList<>();
    BufferedReader in;
    StringBuilder rawJson;
    Gson g = new Gson();


    public ParseJson(String path){
        try {
            this.in = new BufferedReader(new FileReader(path));
            this.line = in.readLine();
        } catch(Exception e){
            System.out.println("ERROR: Problem with reading file.");
        }
        this.rawJson = new StringBuilder();
    }


    public String createJsonString(){
        while (this.line != null) {
            rawJson.append(line).append('\n');
            try {
                line = in.readLine();
            } catch(Exception e){
                return "Error reading file!";
            }
        }
        String json = rawJson.toString();
        return json;
    }

    public void printGsonData(){
        System.out.println(g.fromJson(json, String[].class));
    }
}
