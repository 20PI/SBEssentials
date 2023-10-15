package pye.twenty.sbessentials.sign;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerOpenSignEditor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import pye.twenty.sbessentials.SBEssentials;
import pye.twenty.sbessentials.gui.GUI;

public class SignInputGUI {
    private final GUI parent;
    private final String[] lines;
    private final Player player;
    private final SignAction action;
    private Location location;

    public SignInputGUI(GUI parent, String[] lines, Player player, SignAction action) {
        this.parent = parent;
        this.lines = lines;
        this.player = player;
        this.action = action;
        openSign();
    }

    private void openSign() {
        Location playerLocation = player.getLocation();
        Vector direction = playerLocation.getDirection().normalize().multiply(-2);
        location = playerLocation.add(direction).toBlockLocation();

        Vector3i position = new Vector3i(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        player.sendBlockChange(location, Material.OAK_SIGN.createBlockData());
        player.sendSignChange(location, lines);
        WrapperPlayServerOpenSignEditor sign = new WrapperPlayServerOpenSignEditor(position, true);
        PacketEvents.getAPI().getPlayerManager().sendPacket(player, sign);


    }

    public void input(String string) {
        action.receive(string);
        player.sendBlockChange(location, location.getBlock().getBlockData());
        new BukkitRunnable() {
            @Override
            public void run() {
                parent.reopen(true);
            }
        }.runTask(SBEssentials.INSTANCE.getPlugin());

    }
}
