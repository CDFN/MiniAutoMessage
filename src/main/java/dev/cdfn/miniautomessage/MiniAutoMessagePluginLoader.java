package dev.cdfn.miniautomessage;

import io.papermc.paper.plugin.loader.PluginClasspathBuilder;
import io.papermc.paper.plugin.loader.PluginLoader;
import io.papermc.paper.plugin.loader.library.impl.MavenLibraryResolver;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.repository.RemoteRepository;
import org.jetbrains.annotations.NotNull;

public class MiniAutoMessagePluginLoader implements PluginLoader {
  @Override
  public void classloader(@NotNull PluginClasspathBuilder classpathBuilder) {
    MavenLibraryResolver mavenLibraryResolver = new MavenLibraryResolver();
    mavenLibraryResolver.addRepository(new RemoteRepository.Builder("okaeri-repo", "default", "https://storehouse.okaeri.eu/repository/maven-public/").build());
    mavenLibraryResolver.addDependency(new Dependency(new DefaultArtifact("eu.okaeri:okaeri-configs-hjson:5.0.0-beta.5"), null));
    mavenLibraryResolver.addDependency(new Dependency(new DefaultArtifact("eu.okaeri:okaeri-configs-serdes-commons:5.0.0-beta.5"), null));
    classpathBuilder.addLibrary(mavenLibraryResolver);
  }
}
