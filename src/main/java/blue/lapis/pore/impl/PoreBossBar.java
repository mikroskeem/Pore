package blue.lapis.pore.impl;

import blue.lapis.pore.converter.type.world.bossbar.BossBarColorConverter;
import blue.lapis.pore.converter.type.world.bossbar.BossBarStyleConverter;
import blue.lapis.pore.converter.wrapper.WrapperConverter;
import blue.lapis.pore.impl.entity.PorePlayer;
import blue.lapis.pore.util.PoreText;
import blue.lapis.pore.util.PoreWrapper;
import com.google.common.collect.ImmutableList;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.spongepowered.api.boss.ServerBossBar;
import org.spongepowered.api.text.Text;

import java.util.List;

/**
 * @author Mark Vainomaa
 */
public class PoreBossBar extends PoreWrapper<ServerBossBar> implements BossBar {
    public static PoreBossBar of(ServerBossBar handle) {
        return WrapperConverter.of(PoreBossBar.class, handle);
    }

    protected PoreBossBar(ServerBossBar handle) {
        super(handle);
    }

    @Override
    @SuppressWarnings("deprecation")
    public String getTitle() {
        return PoreText.convert(getHandle().getName());
    }

    @Override
    public void setTitle(String title) {
        getHandle().setName(Text.of(title));
    }

    @Override
    public BarColor getColor() {
        return BossBarColorConverter.of(getHandle().getColor());
    }

    @Override
    public void setColor(BarColor color) {
        getHandle().setColor(BossBarColorConverter.of(color));
    }

    @Override
    public BarStyle getStyle() {
        return BossBarStyleConverter.of(getHandle().getOverlay());
    }

    @Override
    public void setStyle(BarStyle style) {
        getHandle().setOverlay(BossBarStyleConverter.of(style));
    }

    @Override
    public void removeFlag(BarFlag flag) {
        switch(flag) {
            case CREATE_FOG:
                getHandle().setCreateFog(false);
                break;
            case DARKEN_SKY:
                getHandle().setDarkenSky(false);
                break;
            case PLAY_BOSS_MUSIC:
                getHandle().setPlayEndBossMusic(false);
                break;
        }
    }

    @Override
    public void addFlag(BarFlag flag) {
        switch(flag) {
            case CREATE_FOG:
                getHandle().setCreateFog(true);
                break;
            case DARKEN_SKY:
                getHandle().setDarkenSky(true);
                break;
            case PLAY_BOSS_MUSIC:
                getHandle().setPlayEndBossMusic(true);
                break;
        }
    }

    @Override
    public boolean hasFlag(BarFlag flag) {
        boolean value = false;
        switch(flag) {
            case CREATE_FOG:
                value = getHandle().shouldCreateFog();
                break;
            case DARKEN_SKY:
                value = getHandle().shouldDarkenSky();
                break;
            case PLAY_BOSS_MUSIC:
                value = getHandle().shouldPlayEndBossMusic();
                break;
        }
        return value;
    }

    @Override
    public void setProgress(double progress) {
        getHandle().setPercent((float) progress);
    }

    @Override
    public double getProgress() {
        return (double) getHandle().getPercent();
    }

    @Override
    public void addPlayer(Player player) {
        PorePlayer porePlayer = (PorePlayer) player;
        getHandle().addPlayer(porePlayer.getHandle());
    }

    @Override
    public void removePlayer(Player player) {
        PorePlayer porePlayer = (PorePlayer) player;
        getHandle().removePlayer(porePlayer.getHandle());
    }

    @Override
    public void removeAll() {
        getHandle().removePlayers(getHandle().getPlayers());
    }

    @Override
    public List<Player> getPlayers() {
        return getHandle().getPlayers().stream()
                .map(PorePlayer::of)
                .collect(ImmutableList.toImmutableList());
    }

    @Override
    public void setVisible(boolean visible) {
        getHandle().setVisible(visible);
    }

    @Override
    public boolean isVisible() {
        return getHandle().isVisible();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void show() {
        setVisible(true);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void hide() {
        setVisible(false);
    }
}
