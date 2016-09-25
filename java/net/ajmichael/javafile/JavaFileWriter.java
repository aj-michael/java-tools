package net.ajmichael.javafile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Consumer;

public final class JavaFileWriter implements Consumer<JavaFile> {
  @Override
  public void accept(JavaFile javaFile) {
    StringBuilder fileBuilder = new StringBuilder();
    fileBuilder.append(String.format("class %s {\n", javaFile.name()));
    fileBuilder.append("}\n");
    try {
      javaFile.path().getParent().toFile().mkdirs();
      Files.write(javaFile.path(), fileBuilder.toString().getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
