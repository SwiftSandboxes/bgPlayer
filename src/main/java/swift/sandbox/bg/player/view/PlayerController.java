package swift.sandbox.bg.player.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;
import swift.sandbox.bg.player.controller.PlayerService;

@Component
@RequiredArgsConstructor
public class PlayerController {


    private final PlayerService playerService;

    @GetMapping
    public List<PlayerDto> getActivePlayers(String gameSessionId) {
        return playerService.getActivePlayers(gameSessionId);
    }

    @GetMapping
    public PlayerDto getPlayer(String playerId) {
        return playerService.getPlayer(playerId);
    }

    @PostMapping
    public PlayerDto createPlayer(@RequestBody PlayerDto playerDto) {
        return playerService.createPlayer(playerDto);
    }

    public PlayerDto updatePlayer(@RequestBody PlayerDto playerDto) {
        return playerService.updatePlayer(playerDto);
    }
}
