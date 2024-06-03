package swift.sandbox.bg.player.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import swift.sandbox.bg.player.model.BgPlayer;
import swift.sandbox.bg.player.view.PlayerDto;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final BgPlayerMapper bgPlayerMapper;

    public List<PlayerDto> getActivePlayers(String gameSessionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivePlayers'");
    }

    public PlayerDto getPlayer(String playerId) {
        // TODO this is just a dummy testing method and needs to be implemented
        return PlayerDto.builder()
        .givenName("given")
        .surName("sur".concat(Objects.requireNonNullElse(playerId, "-PlayerIdWasNull")))
        .build();
    }

    public PlayerDto createPlayer(PlayerDto player) {
        BgPlayer bgPlayer = bgPlayerMapper.toBgPlayer(player);
        
        //TODO do stuff to save to database

        return bgPlayerMapper.toDto(bgPlayer);
    }

    public PlayerDto updatePlayer(PlayerDto player) {
        BgPlayer bgPlayer = bgPlayerMapper.toBgPlayer(player);
        
        //TODO do stuff to save to database

        return bgPlayerMapper.toDto(bgPlayer);
    }
}
