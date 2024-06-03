package swift.sandbox.bg.player.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class BgPlayer {

    @Id

    @Getter
    @NonNull
    private String givenName;

    @Getter
    @Setter
    @NonNull
    private String surName;
}
