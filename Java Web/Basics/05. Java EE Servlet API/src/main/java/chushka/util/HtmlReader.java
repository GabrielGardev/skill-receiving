package chushka.util;

import java.io.*;

public class HtmlReader {

    public String readHtmlFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

        StringBuilder htmlFileContent = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            htmlFileContent.append(line).append(System.lineSeparator());
        }

        return htmlFileContent.toString().trim();
    }
}
