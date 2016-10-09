package net.ajmichael.converters;

import com.google.common.collect.ImmutableMap;
import net.ajmichael.classfile.ClassFile;
import net.ajmichael.javafile.JavaFile;

import java.nio.file.Path;
import java.util.function.Function;

public final class Converter {
  private Converter() {}

  public static Function<ClassFile, JavaFile> classToJava() {
    return new ClassToJava();
  }

  public static Function<JavaFile, ImmutableMap<Path, ClassFile>> javaToClass() {
    return new JavaToClass();
  }
}
