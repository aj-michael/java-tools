package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class EncodedCatchHandler {
  public static Builder builder() {
    return new AutoValue_EncodedCatchHandler.Builder();
  }

  public abstract int size();

  public abstract ImmutableList<EncodedTypeAddressPair> handlers();

  public abstract int catchAllAddress();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract EncodedCatchHandler build();

    public abstract Builder setSize(int value);

    public abstract Builder setHandlers(ImmutableList<EncodedTypeAddressPair> value);

    public abstract Builder setCatchAllAddress(int value);
  }
}
