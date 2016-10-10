package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class Code {
  public static Builder builder() {
    return new AutoValue_Code.Builder();
  }

  public abstract short registersSize();

  public abstract short insSize();

  public abstract short outsSize();

  public abstract short triesSize();

  public abstract int debugInfoOffset();

  public abstract int instructionsSize();

  public abstract ImmutableList<Short> instructions();

  public abstract short padding();

  public abstract ImmutableList<Try> tries();

  public abstract ImmutableList<EncodedCatchHandler> handlers();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Code build();

    public abstract Builder setRegistersSize(short value);

    public abstract Builder setInsSize(short value);

    public abstract Builder setOutsSize(short value);

    public abstract Builder setTriesSize(short value);

    public abstract Builder setDebugInfoOffset(int value);

    public abstract Builder setInstructionsSize(int value);

    public abstract Builder setInstructions(ImmutableList<Short> value);

    public abstract Builder setPadding(short value);

    public abstract Builder setTries(ImmutableList<Try> value);

    public abstract Builder setHandlers(ImmutableList<EncodedCatchHandler> value);
  }
}
