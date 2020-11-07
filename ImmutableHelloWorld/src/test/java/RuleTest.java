import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class RuleTest {
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder(new File("/Users/rainforest/Dev/tmp"));

    @Test
    public void testTemporaryFolder() throws IOException, InterruptedException {
        File f = folder.newFile("log");
        TimeUnit.SECONDS.sleep(10);
    }
}
