package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class MethodTypeInfo implements ConstantPoolInfo {
  public static MethodTypeInfo parse(ByteBuffer classFile) {
    return MethodTypeInfo.builder()
        .setDescriptorIndex(classFile.getShort())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_MethodTypeInfo.Builder();
  }

  public Byte tag() {
    return 16;
  }

  public abstract Short descriptorIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodTypeInfo build();

    public abstract Builder setDescriptorIndex(Short value);
  }
}
