package dev.cdfn.miniautomessage.config;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;

import java.time.Duration;
import java.util.List;

public class MessageBucket extends OkaeriConfig {

  @Comment("Interval at which messages will be sent")
  public Duration interval = Duration.ofSeconds(30);

  @Comment("Messages to choose from")
  public List<AutoMessage> messages = List.of(new AutoMessage());

  @Comment("Method that will be used to select message to send")
  public SelectionMethod method = SelectionMethod.RANDOM;
}
