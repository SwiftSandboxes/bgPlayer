package swift.sandbox.bg.player.view;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class PlayerDto {

    @Getter
    @NonNull
    private String givenName;

    @Getter
    @NonNull
    private String surName;
}
