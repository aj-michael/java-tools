package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EncodedField {
  public static Builder builder() {
    return new AutoValue_EncodedField.Builder();
  }

  public abstract int fieldIndexDiff();

  public abstract int accessFlags();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract EncodedField build();

    public abstract Builder setFieldIndexDiff(int value);

    public abstract Builder setAccessFlags(int value);
  }
}
