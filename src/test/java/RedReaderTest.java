import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class RedReaderTest {
    @Test
    public void RedReader() throws IOException, ParseException {
        RedReader rsvpTest= new RedReader();
       var i=0;
        i= rsvpTest.pause;

        assertNotEquals(0,i);
    }

}