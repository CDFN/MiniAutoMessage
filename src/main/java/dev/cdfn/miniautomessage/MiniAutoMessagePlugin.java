package dev.cdfn.miniautomessage;

import dev.cdfn.miniautomessage.automessage.task.AutoMessageTask;
import dev.cdfn.miniautomessage.config.MiniAutoMessageConfig;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.hjson.HjsonConfigurer;
import eu.okaeri.configs.serdes.commons.SerdesCommons;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.time.Duration;

public final class MiniAutoMessagePlugin extends JavaPlugin {
  @Override
  public void onEnable() {
    // Plugin startup logic
    var config = (MiniAutoMessageConfig) ConfigManager.create(MiniAutoMessageConfig.class)
        .withConfigurer(new HjsonConfigurer(), new SerdesCommons())
        .withBindFile(new File(this.getDataFolder(), "config.hjson"))
        .withRemoveOrphans(true)
        .saveDefaults()
        .load(true);
    config.buckets.forEach(bucket -> this.getServer().getScheduler().runTaskTimer(
        this,
        new AutoMessageTask(bucket),
        this.durationToTicks(bucket.interval),
        this.durationToTicks(bucket.interval)
    ));
  }

  private long durationToTicks(Duration duration) {
    return duration.getSeconds() * 20;
  }
}
