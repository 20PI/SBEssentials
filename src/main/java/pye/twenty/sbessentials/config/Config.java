package pye.twenty.sbessentials.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class Config {

    private final File file;
    protected final YamlConfiguration config;

    public Config(String path) {
        this.file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }
    public final YamlConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            this.config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefault(String path, Object value) {
        if (!config.contains(path)) {
            config.set(path, value);
            saveConfig();
        }
    }
}
