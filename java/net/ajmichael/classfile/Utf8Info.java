package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.nio.ByteBuffer;

import static net.ajmichael.util.Helpers.applyN;

@AutoValue
public abstract class Utf8Info implements ConstantPoolInfo {
  public static Utf8Info parse(ByteBuffer classFile) {
    short length = classFile.getShort();
    return Utf8Info.builder()
        .setLength(length)
        .setBytes(applyN(length, ByteBuffer::get, classFile))
        .build();
  }

  public static Builder builder() {
    return new AutoValue_Utf8Info.Builder();
  }

  public Byte tag() {
    return 1;
  }

  public abstract Short length();

  public abstract ImmutableList<Byte> bytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Utf8Info build();

    public abstract Builder setLength(Short value);

    public abstract Builder setBytes(ImmutableList<Byte> value);
  }
}
