package pye.twenty.sbessentials.gui;

import lombok.Getter;

@Getter
public enum Slot {
    FIRST(4),
    SECOND(13),
    THIRD(22),
    FOURTH(31),
    FIFTH(40),
    SIXTH(49);

    private final int center;
    Slot(int center) {
        this.center = center;
    }
}
