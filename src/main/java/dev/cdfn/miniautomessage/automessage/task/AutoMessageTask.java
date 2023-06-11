package dev.cdfn.miniautomessage.automessage.task;

import dev.cdfn.miniautomessage.config.AutoMessage;
import dev.cdfn.miniautomessage.config.MessageBucket;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;

import java.util.concurrent.ThreadLocalRandom;

public class AutoMessageTask implements Runnable {
  private final MessageBucket messageBucket;

  public AutoMessageTask(MessageBucket messageBucket) {
    this.messageBucket = messageBucket;
  }

  @Override
  public void run() {
    AutoMessage message = messageBucket.messages.get(ThreadLocalRandom.current().nextInt(messageBucket.messages.size()));
    Bukkit.broadcast(MiniMessage.miniMessage().deserialize(message.message));
  }
}
