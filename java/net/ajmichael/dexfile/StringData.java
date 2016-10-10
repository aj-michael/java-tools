package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class StringData {
  public static Builder builder() {
    return new AutoValue_StringData.Builder();
  }

  public abstract int utf16Size();

  public abstract ImmutableList<Byte> data();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract StringData build();

    public abstract Builder setUtf16Size(int value);

    public abstract Builder setData(ImmutableList<Byte> value);
  }
}
