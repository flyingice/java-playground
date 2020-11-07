import org.immutables.value.Value;
import org.immutables.value.Value.Parameter;

import java.util.List;
import java.util.Optional;

@Value.Immutable
public interface SimpleDataModel {
    @Parameter
    int id();
    @Parameter
    String name();
    Optional<String> comment();
    List<Integer> numbers();
}
