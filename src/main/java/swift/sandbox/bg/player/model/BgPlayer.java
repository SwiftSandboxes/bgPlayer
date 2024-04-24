package swift.sandbox.bg.player.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BgPlayer {

    @Getter
    @NonNull
    private String givenName;

    @Getter
    @NonNull
    private String surName;
}
