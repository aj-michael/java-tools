package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class StringInfo implements ConstantPoolInfo {
  public static StringInfo parse(ByteBuffer classFile) {
    return StringInfo.builder()
        .setStringIndex(classFile.getShort())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_StringInfo.Builder();
  }

  public Byte tag() {
    return 8;
  }

  public abstract Short stringIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract StringInfo build();

    public abstract Builder setStringIndex(Short value);
  }
}
