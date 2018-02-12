package blue.lapis.pore.converter.type.world.bossbar;

import blue.lapis.pore.converter.type.TypeConverter;
import com.google.common.base.Converter;
import org.bukkit.boss.BarStyle;
import org.spongepowered.api.boss.BossBarOverlay;
import org.spongepowered.api.boss.BossBarOverlays;

/**
 * @author Mark Vainomaa
 */
public final class BossBarStyleConverter {

    private BossBarStyleConverter() {
    }

    private static final Converter<BarStyle, BossBarOverlay> CONVERTER = TypeConverter.builder(BarStyle.class, BossBarOverlay.class)
            .add(BarStyle.SEGMENTED_6, BossBarOverlays.NOTCHED_6)
            .add(BarStyle.SEGMENTED_10, BossBarOverlays.NOTCHED_10)
            .add(BarStyle.SEGMENTED_12, BossBarOverlays.NOTCHED_12)
            .add(BarStyle.SEGMENTED_20, BossBarOverlays.NOTCHED_20)
            .add(BarStyle.SOLID, BossBarOverlays.PROGRESS)
            .build();

    public static BossBarOverlay of(BarStyle barStyle) {
        return CONVERTER.convert(barStyle);
    }

    public static BarStyle of(BossBarOverlay bossBarOverlay) {
        return CONVERTER.reverse().convert(bossBarOverlay);
    }
}
