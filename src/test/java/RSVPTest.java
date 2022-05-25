import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class RSVPTest {
    @Test
    public void rsvp() throws IOException, ParseException {
        RSVP rsvpTest= new RSVP();
        File filePath = new File("\\Users\\Admin\\Desktop\\test.txt");
        File testFile= null;
        try {
            testFile = rsvpTest.rsvp(400, filePath );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(testFile);
    }

}