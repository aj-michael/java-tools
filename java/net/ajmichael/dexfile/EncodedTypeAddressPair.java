package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EncodedTypeAddressPair {
  public static Builder builder() {
    return new AutoValue_EncodedTypeAddressPair.Builder();
  }

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract EncodedTypeAddressPair build();
  }
}
