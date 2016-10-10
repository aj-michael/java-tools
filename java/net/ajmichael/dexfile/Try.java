package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Try {
  public static Builder builder() {
    return new AutoValue_Try.Builder();
  }

  public abstract int startAddress();

  public abstract short instructionsCount();

  public abstract short handlerOffset();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Try build();

    public abstract Builder setStartAddress(int value);

    public abstract Builder setInstructionsCount(short value);

    public abstract Builder setHandlerOffset(short value);
  }
}
