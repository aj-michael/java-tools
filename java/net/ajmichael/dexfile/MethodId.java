package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class MethodId {
  public static MethodId parse(ByteBuffer byteBuffer) {
    return builder()
        .setClassIndex(byteBuffer.getShort())
        .setProtoIndex(byteBuffer.getShort())
        .setNameIndex(byteBuffer.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_MethodId.Builder();
  }

  public abstract short classIndex();

  public abstract short protoIndex();

  public abstract int nameIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodId build();

    public abstract Builder setClassIndex(short value);

    public abstract Builder setProtoIndex(short value);

    public abstract Builder setNameIndex(int value);
  }
}
