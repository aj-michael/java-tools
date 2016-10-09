package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class ProtoId {
  public static ProtoId parse(ByteBuffer byteBuffer) {
    return builder()
        .setShortyIndex(byteBuffer.getInt())
        .setReturnTypeIndex(byteBuffer.getInt())
        .setParametersOffset(byteBuffer.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_ProtoId.Builder();
  }

  public abstract int shortyIndex();

  public abstract int returnTypeIndex();

  public abstract int parametersOffset();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract ProtoId build();

    public abstract Builder setShortyIndex(int value);

    public abstract Builder setReturnTypeIndex(int value);

    public abstract Builder setParametersOffset(int value);
  }
}
