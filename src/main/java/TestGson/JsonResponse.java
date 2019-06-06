package TestGson;

public class JsonResponse {
    private String author;
    private String text;

    public JsonResponse(String author, String text){
        this.author = author;
        this.text = text;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getText(){
        return this.text;
    }

    public String toString(){
        return String.format("%s: %s", this.author, this.text);
    }
}
