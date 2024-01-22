package pye.twenty.sbessentials.util;

import org.bukkit.Location;

public final class AreaUtils {
    public static boolean isWithinArea(Location location, Location min, Location max) {
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        double minX = min.getX();
        double minY = min.getY();
        double minZ = min.getZ();

        double maxX = max.getX();
        double maxY = max.getY();
        double maxZ = max.getZ();

        return x >= minX && x <= maxX
                && y >= minY && y <= maxY
                && z >= minZ && z <= maxZ;
    }
}
