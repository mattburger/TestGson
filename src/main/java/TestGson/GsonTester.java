package TestGson;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class ParseJson {

    BufferedReader in;
    Gson g = new Gson();
    JsonResponse[] recentQuotes;


    public ParseJson(String path) {
        try {
            this.in = new BufferedReader(new FileReader(path));

        } catch (Exception e) {
            System.out.println("ERROR: Problem with file.");
        }
    }

    public void createResponseList(){
        this.recentQuotes = g.fromJson(this.in, JsonResponse[].class );
    }

    public void printRandom(){
//        int length = this.recentQuotes.size();
        int range = this.recentQuotes.length;
        int randInteger = (int)(Math.random() * range) + 1;
        System.out.println(this.recentQuotes[randInteger].toString() );
    }
}