package TestGson;

public class JsonResponse {
    private String author;
    private String text;
    protected int id;
    protected String starWarsQuote;
    protected int faction;

    public JsonResponse(int id, String starWarsQuote, int faction) {
        this.id = id;
        this.starWarsQuote = starWarsQuote;
        this.faction = faction;
    }


    public JsonResponse(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getText() {
        return this.text;
    }

    public String getStarWarsQuote() {
        return this.starWarsQuote;
    }


    public String toString() {
        return String.format("%s: %s", this.author, this.text);
    }
//
//    public String toString() {
//        return String.format("%s", this.starWarsQuote);
//    }

}

