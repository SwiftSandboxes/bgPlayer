package swift.sandbox.bg.player.controller;

import org.mapstruct.Mapper;
// import org.mapstruct.factory.Mappers;

import swift.sandbox.bg.player.model.BgPlayer;
import swift.sandbox.bg.player.view.PlayerDto;

@Mapper
public interface BgPlayerMapper {
    // BgPlayerMapper INSTANCE = Mappers.getMapper(BgPlayerMapper.class);


    BgPlayer toBgPlayer(PlayerDto product);

    PlayerDto toDto(BgPlayer bgPlayer);
}
