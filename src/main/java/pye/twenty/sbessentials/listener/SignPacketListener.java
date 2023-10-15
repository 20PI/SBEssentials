package pye.twenty.sbessentials.listener;

import com.github.retrooper.packetevents.event.SimplePacketListenerAbstract;
import com.github.retrooper.packetevents.event.simple.PacketPlayReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientUpdateSign;
import org.bukkit.entity.Player;
import pye.twenty.sbessentials.SBEssentials;

import java.util.logging.Level;

public class SignPacketListener extends SimplePacketListenerAbstract {

    @Override
    public void onPacketPlayReceive(PacketPlayReceiveEvent event) {
        if (event.getPacketType().equals(PacketType.Play.Client.UPDATE_SIGN)) {
            WrapperPlayClientUpdateSign sign = new WrapperPlayClientUpdateSign(event);
            SBEssentials.getGUI((Player) event.getPlayer()).ifPresent(gui -> {
                if (gui.getSignInputGUI() != null) {
                    gui.getSignInputGUI().input(sign.getTextLines()[0]);
                    SBEssentials.INSTANCE.getPlugin().getLogger().log(Level.INFO, "Received sign info -> %s".formatted(sign.getTextLines()[0]));
                }
            });
        }
    }

}