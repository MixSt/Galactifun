package io.github.addoncommunity.galactifun.core.commands;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.addoncommunity.galactifun.Galactifun;
import io.github.addoncommunity.galactifun.api.universe.attributes.atmosphere.AtmosphericEffect;
import io.github.addoncommunity.galactifun.api.worlds.PlanetaryWorld;
import io.github.mooy1.infinitylib.commands.SubCommand;

public final class EffectsCommand extends SubCommand {

    public EffectsCommand() {
        super("effects", "Получает все эффекты текущего блока (с учетом защиты)", false);
    }

    @Override
    public void execute(@Nonnull CommandSender commandSender, @Nonnull String[] strings) {
        if (!(commandSender instanceof Player p)) return;

        PlanetaryWorld world = Galactifun.worldManager().getWorld(p.getWorld());
        if (world == null) {
            p.sendMessage(ChatColor.RED + "Вы должны находиться на одной из планет, чтобы выполнить эту команду");
            return;
        }

        for (Map.Entry<AtmosphericEffect, Integer> entry : Galactifun.protectionManager().getEffectsAt(p.getLocation()).entrySet()) {
            p.sendMessage(ChatColor.YELLOW + String.format("Эффект: %s, Уровень: %d",
                    entry.getKey().toString(),
                    entry.getValue()
            ));
        }
    }

    @Override
    public void complete(@Nonnull CommandSender commandSender, @Nonnull String[] strings, @Nonnull List<String> list) {

    }

}
