package TestGson;

import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestGsonTester {

    String path = "src/main/resources/recentquotes.json";
    @Test
    public void testConstructor(){
        GsonTester p = new GsonTester(path);
        assertNotNull("this.in of p should not be null.", p.in);
    }

    @Test(expected = IllegalStateException.class)
    public void testConstructor_fail() {
        GsonTester p = new GsonTester("src/wrong.json");
        assertNotNull("The variable holding the file instance should be null.", p.in);
    }
    @Test
    public void testCreateResponseList(){
        GsonTester p = new GsonTester(path);
        p.createResponseList();
        assertNotNull("The list that is a result of this function should not be null.", p.getRecentQuotes());
    }

    @Test
    public void testGetSwData(){
        GsonTester p = new GsonTester(path);
        String output = p.getSwData(path);
        assertNotNull("getSwData should return a quote of type string.", output);
    }

    @Test
    public void testGetSwData_fail(){
        GsonTester p = new GsonTester(path);
        String output = p.getSwData("src/wrong.json");
        assertEquals("Exception should caught and message returned.", "Error handling Star Wars quotes.", output);
    }

    @Test
    public void testcreateResponseListandPrintRandom(){
        GsonTester p = new GsonTester(path);
        p.createResponseList();
        assertNotNull("createResponseList should implement the list for recent quotes, and printRandom should return a random quote locally as a string.",p.printRandom() );
    }
}
