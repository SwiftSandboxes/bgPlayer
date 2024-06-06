package swift.sandbox.bg.player.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import swift.sandbox.bg.player.model.BgPlayer;
import swift.sandbox.bg.player.model.BgPlayerRepository;
import swift.sandbox.bg.player.view.PlayerDto;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    private PlayerService playerService;
    private BgPlayerMapper mapper;
    @Mock
    private BgPlayerRepository mockPlayerRepository;

    @BeforeEach
    void setUp() {
        mapper = new BgPlayerMapperImpl();
        playerService = new PlayerService(mapper, mockPlayerRepository);
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

    @Test
    void testCreatePlayer() {
        String givenName = "Bob";
        String surName = "Tester";
        PlayerDto pToCreate = PlayerDto.builder().givenName(givenName).surName(surName).build();
        BgPlayer dbPlayer = new BgPlayer(1, givenName, surName);
        when(mockPlayerRepository.save(any(BgPlayer.class))).thenReturn(dbPlayer);
        
        PlayerDto savedPlayer = playerService.createPlayer(pToCreate);
        
        verify(mockPlayerRepository, times(1)).save(any(BgPlayer.class));
        assertEquals(1, savedPlayer.getId());
    }
}
