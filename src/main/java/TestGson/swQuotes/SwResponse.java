package TestGson.swQuotes;

public class SwResponse {
    protected int id;
    protected String starWarsQuote;
    protected int faction;

    public SwResponse(int id, String starWarsQuote, int faction){
        this.id = id;
        this.starWarsQuote = starWarsQuote;
        this.faction = faction;
    }

    public String getStarWarsQuote(){
        return this.starWarsQuote;
    }
    public String toString(){
        return String.format("%s",this.starWarsQuote);
    }

}
