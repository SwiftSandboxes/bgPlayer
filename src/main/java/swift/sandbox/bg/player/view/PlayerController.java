package swift.sandbox.bg.player.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import swift.sandbox.bg.player.controller.PlayerService;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {


    private final PlayerService playerService;

    @GetMapping("/gameSession/{gameSessionId}")
    public List<PlayerDto> getActivePlayers(String gameSessionId) {
        return playerService.getActivePlayers(gameSessionId);
    }

    @GetMapping
    public PlayerDto getPlayer(@RequestParam String playerId) {
        return playerService.getPlayer(playerId);
    }

    @PostMapping
    public PlayerDto createPlayer(@RequestBody PlayerDto playerDto) {
        return playerService.createPlayer(playerDto);
    }

    @PutMapping
    public PlayerDto updatePlayer(@RequestBody PlayerDto playerDto) {
        return playerService.updatePlayer(playerDto);
    }
}
