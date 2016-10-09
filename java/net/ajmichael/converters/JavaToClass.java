package net.ajmichael.converters;

import com.google.common.collect.ImmutableMap;
import net.ajmichael.classfile.ClassFile;
import net.ajmichael.javafile.JavaFile;

import java.nio.file.Path;
import java.util.function.Function;

final class JavaToClass implements Function<JavaFile, ImmutableMap<Path, ClassFile>> {
  @Override
  public ImmutableMap<Path, ClassFile> apply(JavaFile javaFile) {
    return null;
  }
}
