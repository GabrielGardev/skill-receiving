package softuni.usersystem.utils.impl;

import org.springframework.stereotype.Component;
import softuni.usersystem.utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtilImpl implements FileUtil {

    @Override
    public String[][] fileContent(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<String[]> resultList = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null){
            resultList.add(line.split("\\s+"));
        }
        return resultList
                .stream()
                .filter(r -> !r[0].equals(""))
                .toArray(String[][]::new);
    }
}
