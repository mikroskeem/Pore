package net.amigocraft.pore.implementation.entity;

import org.bukkit.entity.Creeper;



public class PoreCreeper extends PoreMonster implements Creeper {
    @Override
    public boolean isPowered() {
        return false;
    }

    @Override
    public void setPowered(boolean value) {

    }
}
