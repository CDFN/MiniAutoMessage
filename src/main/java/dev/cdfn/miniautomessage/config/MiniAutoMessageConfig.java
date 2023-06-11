package dev.cdfn.miniautomessage.config;

import eu.okaeri.configs.OkaeriConfig;

import java.util.List;

public class MiniAutoMessageConfig extends OkaeriConfig {
  public List<MessageBucket> buckets = List.of(new MessageBucket());
}
