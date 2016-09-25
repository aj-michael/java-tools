package net.ajmichael.converters;

import com.google.common.primitives.Bytes;
import net.ajmichael.classfile.ClassFile;
import net.ajmichael.classfile.ClassInfo;
import net.ajmichael.classfile.Utf8Info;
import net.ajmichael.javafile.JavaFile;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public final class ClassToJava implements Function<ClassFile, JavaFile> {
  @Override
  public JavaFile apply(ClassFile classFile) {
    JavaFile.Builder builder = JavaFile.builder()
        .setFullName(getClassName(classFile));
    return builder.build();
  }

  private static String getClassName(ClassFile classFile) {
    ClassInfo classInfo = (ClassInfo) classFile.constantPool().get(classFile.thisClass() - 1);
    Utf8Info utf8Info = (Utf8Info) classFile.constantPool().get(classInfo.nameIndex() - 1);
    return new String(Bytes.toArray(utf8Info.bytes()), StandardCharsets.UTF_8);
  }
}
