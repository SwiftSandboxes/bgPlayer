package swift.sandbox.bg.player.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.datafaker.Faker;
import swift.sandbox.bg.player.controller.PlayerService;

@ExtendWith(MockitoExtension.class)
public class PlayerControllerTest {

    private Faker faker = new Faker();
    
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private PlayerService playerService;

    @Test
    void testCreatePlayer() {
        PlayerController playerController = new PlayerController(playerService);

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        PlayerDto playerDto = PlayerDto.builder().givenName(firstName).surName(lastName).build();
   
        when(playerService.createPlayer(playerDto)).thenReturn(playerDto);

        PlayerDto playerToVerify = playerController.createPlayer(playerDto);

        verify(playerService, times(1)).createPlayer(any(PlayerDto.class));
        assertEquals(playerDto.getGivenName(), playerToVerify.getGivenName());
        assertEquals(playerDto.getSurName(), playerToVerify.getSurName());
    }

    @Test
    void testGetActivePlayers() {

    }

    @Test
    void testGetPlayer() {

    }

    @Test
    void testUpdatePlayer() {

    }
}
