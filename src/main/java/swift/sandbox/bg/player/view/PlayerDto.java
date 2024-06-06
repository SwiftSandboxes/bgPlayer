package swift.sandbox.bg.player.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PlayerDto {

    @Getter
    private Integer id;

    @Getter
    @NonNull
    private String givenName;

    @Getter
    @NonNull
    private String surName;
}
