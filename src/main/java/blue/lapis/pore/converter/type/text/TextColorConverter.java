package blue.lapis.pore.converter.type.text;

import blue.lapis.pore.converter.type.TypeConverter;
import com.google.common.base.Converter;
import org.bukkit.ChatColor;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

/**
 * @author Mark Vainomaa
 */
public final class TextColorConverter {
    private TextColorConverter() {}

    private static final Converter<ChatColor, TextColor> CONVERTER =
            TypeConverter.builder(ChatColor.class, TextColor.class)
                    .add(ChatColor.AQUA, TextColors.AQUA)
                    .add(ChatColor.BLACK, TextColors.BLACK)
                    .add(ChatColor.BLUE, TextColors.BLUE)
                    .add(ChatColor.DARK_AQUA, TextColors.DARK_AQUA)
                    .add(ChatColor.DARK_BLUE, TextColors.DARK_BLUE)
                    .add(ChatColor.DARK_GRAY, TextColors.DARK_GRAY)
                    .add(ChatColor.DARK_GREEN, TextColors.DARK_GREEN)
                    .add(ChatColor.DARK_PURPLE, TextColors.DARK_PURPLE)
                    .add(ChatColor.DARK_RED, TextColors.DARK_RED)
                    .add(ChatColor.GOLD, TextColors.GOLD)
                    .add(ChatColor.GRAY, TextColors.GRAY)
                    .add(ChatColor.GREEN, TextColors.GREEN)
                    .add(ChatColor.LIGHT_PURPLE, TextColors.LIGHT_PURPLE)
                    .add(ChatColor.RED, TextColors.RED)
                    .add(ChatColor.WHITE, TextColors.WHITE)
                    .add(ChatColor.YELLOW, TextColors.YELLOW)
                    .build();

    public static TextColor of(ChatColor color) {
        return CONVERTER.convert(color);
    }

    public static ChatColor of(TextColor color) {
        return CONVERTER.reverse().convert(color);
    }
}
