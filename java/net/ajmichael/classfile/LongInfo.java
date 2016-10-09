package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class LongInfo implements ConstantPoolInfo {
  public static LongInfo parse(ByteBuffer classFile) {
    return LongInfo.builder()
        .setHighBytes(classFile.getInt())
        .setLowBytes(classFile.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_LongInfo.Builder();
  }

  public Byte tag() {
    return 5;
  }

  public abstract Integer highBytes();

  public abstract Integer lowBytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract LongInfo build();

    public abstract Builder setHighBytes(Integer value);

    public abstract Builder setLowBytes(Integer value);
  }
}
