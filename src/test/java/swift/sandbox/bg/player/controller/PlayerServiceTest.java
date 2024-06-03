package swift.sandbox.bg.player.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import swift.sandbox.bg.player.view.PlayerDto;

public class PlayerServiceTest {

    private PlayerService playerService;
    @Mock
    private BgPlayerMapper mockMapper;

    @BeforeEach
    void setUp() {
        playerService = new PlayerService(mockMapper);
    }

    @Test
    void testGetPlayer() {
        PlayerDto player = playerService.getPlayer("1");

        assertEquals(player.getSurName(), "sur1");
    }

    @Test
    void testGetPlayerNullId() {
        PlayerDto player = playerService.getPlayer(null);

        assertEquals(player.getSurName(), "sur-PlayerIdWasNull");
    }
}
