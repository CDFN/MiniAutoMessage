package dev.cdfn.miniautomessage.config;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;

public class AutoMessage extends OkaeriConfig {
  @Comment("The message that will be sent. Uses MiniMessage syntax, supports PAPI.")
  public String message = "<red>Check out this cool auto message!";

  @Comment("Priority that will be used when priority-based message selection method has been selected.")
  public int priority = 10;
}
