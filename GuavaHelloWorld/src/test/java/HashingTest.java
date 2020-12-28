import com.google.common.hash.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;

public class HashingTest {
    @Test
    public void testMurmurhash() {
        HashFunction func = Hashing.murmur3_128();
        Hasher hasher = func.newHasher().putInt(1).putString("rainforest", StandardCharsets.UTF_8);
        assertEquals("be34dd37b8fbd9285fcbf58adc47e55a", hasher.hash().toString());
    }

    @Test
    public void testHashingWithSink() {
        HashFunction func = Hashing.sha256();
        Hasher hasher = func.newHasher().putObject(new Apple(), new Funnel<Apple>() {
            @Override
            public void funnel(Apple from, PrimitiveSink into) {
                into.putDouble(from.unitPrice);
                into.putInt(from.color.ordinal());
                new Funnel<Apple.Category>() {
                    @Override
                    public void funnel(Apple.Category from, PrimitiveSink into) {
                        into.putString(from.name, StandardCharsets.UTF_8);
                    }
                }.funnel(from.category, into);
            }
        });
        assertEquals("4a703711c368bb9ea248151bb9be049ade4b87d4aad250ec2e87ec51904e3804", hasher.hash().toString());
    }
}
