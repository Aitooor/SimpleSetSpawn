package online.starsmc.simplesetspawn.utils.location;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class LocationCodec {

    public static String serialize(Location location) {
        return location.getWorld().getName() + ";"
                + location.getX() + ";"
                + location.getY() + ";"
                + location.getZ() + ";"
                + location.getYaw() + ";"
                + location.getPitch();
    }

    public static Location deserialize(String string) {
        String[] data = string.split(";");
        try {
            org.bukkit.World world = Bukkit.getWorld(data[0]);
            double x = Double.parseDouble(data[1]);
            double y = Double.parseDouble(data[2]);
            double z = Double.parseDouble(data[3]);
            float yaw = Float.valueOf(data[4]);
            float pitch = Float.valueOf(data[5]);

            return new Location(world, x, y, z, yaw, pitch);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
