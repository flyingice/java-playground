import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MyValue {
    public static AutoValue_MyValue create(String name, int id) {
        return new AutoValue_MyValue(name, id);
    }
    public abstract String name();
    public abstract int id();
}
