package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class IntegerInfo implements ConstantPoolInfo {
  public static IntegerInfo parse(ByteBuffer classFile) {
    return IntegerInfo.builder().setBytes(classFile.getInt()).build();
  }

  public static Builder builder() {
    return new AutoValue_IntegerInfo.Builder();
  }

  public Byte tag() {
    return 3;
  }

  public abstract Integer bytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract IntegerInfo build();

    public abstract Builder setBytes(Integer value);
  }
}
