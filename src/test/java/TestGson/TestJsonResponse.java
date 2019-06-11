package TestGson;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestJsonResponse {

    @Test
    public void testJsonResponse() {
        JsonResponse notStarWarsResponse = new JsonResponse("me", "A boring quote.");
        JsonResponse starWarsResponse = new JsonResponse(0, "Test we do, young padawon.", 0);

        assertEquals("getAuthor method should return the author's name.",
                "me",notStarWarsResponse.getAuthor());

        assertEquals("getText method should return the text of the quote.",
                "A boring quote.", notStarWarsResponse.getText());

        assertNotNull("getStarWarsQuote should return the random quote from the api.", starWarsResponse.getStarWarsQuote());

        assertEquals("toString should return a string", "me: A boring quote.", notStarWarsResponse.toString());

    }

}
