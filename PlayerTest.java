import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testValidPlayerCreation() {
        Player player = Player.createPlayer(true, "John Smith", 1990);
        assertNotNull(player);
    }

    @Test
    public void testInvalidPlayerCreationDueToAge() {
        Player player = Player.createPlayer(true, "Jane Doe", 2000);
        assertNotNull(player);
    }

    @Test
    public void testSetName() {
        Player player = Player.createPlayer(true, "Michael Jordan", 1980);
        player.setName("LeBron James");
        assertEquals("LeBron James", player.getName());
    }

    @Test
    public void testSetBornYear() {
        Player player = Player.createPlayer(true, "Stephen Curry", 1988);
        player.setBornYear(1990);
        assertEquals(1990, player.getBornYear());
    }
}