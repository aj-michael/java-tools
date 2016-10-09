package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class MethodRefInfo implements ConstantPoolInfo {
  public static MethodRefInfo parse(ByteBuffer classFile) {
    return MethodRefInfo.builder()
        .setClassIndex(classFile.getShort())
        .setNameAndTypeIndex(classFile.getShort())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_MethodRefInfo.Builder();
  }

  public Byte tag() {
    return 10;
  }

  public abstract Short classIndex();

  public abstract Short nameAndTypeIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodRefInfo build();

    public abstract Builder setClassIndex(Short value);

    public abstract Builder setNameAndTypeIndex(Short value);
  }
}
