package net.ajmichael.javad;

import net.ajmichael.classfile.ClassFileParser;
import net.ajmichael.converters.ClassToJava;
import net.ajmichael.javafile.JavaFileWriter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class App {
  public static void main(String[] args) {
    Arrays.stream(args)
        .map(Paths::get)
        .map(App::readAllBytes)
        .map(ByteBuffer::wrap)
        .map(new ClassFileParser())
        .map(new ClassToJava())
        .forEach(new JavaFileWriter());
  }

  private static byte[] readAllBytes(Path path) {
    try {
      return Files.readAllBytes(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
