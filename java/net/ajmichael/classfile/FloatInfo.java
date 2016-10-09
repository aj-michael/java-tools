package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class FloatInfo implements ConstantPoolInfo {
  public static FloatInfo parse(ByteBuffer classFile) {
    return FloatInfo.builder()
        .setBytes(classFile.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_FloatInfo.Builder();
  }

  public Byte tag() {
    return 4;
  }

  public abstract Integer bytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract FloatInfo build();

    public abstract Builder setBytes(Integer value);
  }
}
