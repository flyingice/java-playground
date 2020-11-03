import com.google.inject.*;
import com.google.inject.name.Named;

@ImplementedBy(GreeterPolite.class)
public interface Greeter {
    public void greet();
}
