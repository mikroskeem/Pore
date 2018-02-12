package blue.lapis.pore.converter.type.world.bossbar;

import blue.lapis.pore.converter.type.TypeConverter;
import com.google.common.base.Converter;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarColor;
import org.spongepowered.api.boss.BossBarColor;
import org.spongepowered.api.boss.BossBarColors;
import org.spongepowered.api.boss.BossBarOverlay;
import org.spongepowered.api.boss.BossBarOverlays;

/**
 * @author Mark Vainomaa
 */
public final class BossBarColorConverter {

    private BossBarColorConverter() {
    }

    private static final Converter<BarColor, BossBarColor> CONVERTER = TypeConverter.builder(BarColor.class, BossBarColor.class)
            .add(BarColor.PINK, BossBarColors.PINK)
            .add(BarColor.BLUE, BossBarColors.BLUE)
            .add(BarColor.RED, BossBarColors.RED)
            .add(BarColor.GREEN, BossBarColors.GREEN)
            .add(BarColor.YELLOW, BossBarColors.YELLOW)
            .add(BarColor.PURPLE, BossBarColors.PURPLE)
            .add(BarColor.WHITE, BossBarColors.WHITE)
            .build();

    public static BossBarColor of(BarColor barColor) {
        return CONVERTER.convert(barColor);
    }

    public static BarColor of(BossBarColor bossBarColor) {
        return CONVERTER.reverse().convert(bossBarColor);
    }
}
