package fdmc.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HtmlReader {

    String readHtmlFile(String path) throws IOException;
}
