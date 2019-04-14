package models;

import interfeaces.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private static final String DEFAULT_PATH_AND_NAME = "output.txt";
    private StringBuilder text;
    private int size;
    private String filePathAndName;

    public LogFile() {
        this.text = new StringBuilder();
        this.size = 0;
        this.filePathAndName = LogFile.DEFAULT_PATH_AND_NAME;
    }

    public LogFile(String filePathAndName) {
        this();
        this.filePathAndName = filePathAndName;
    }

    public void setFilePathAndName(String filePathAndName) {
        this.filePathAndName = filePathAndName;
    }

    @Override
    public boolean write() {

        try {
            Files.write(Paths.get(this.filePathAndName),
                    this.text.toString().getBytes(), StandardOpenOption.APPEND);
            return true;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }

    private int calculateSize(){
        int result = 0;

        for (char c : this.text.toString().toCharArray()) {
            if (Character.isLetter(c)){
                result += (int)c;
            }
        }
        return result;
    }

    @Override
    public void append(String text) {
        this.text.append(text);
    }
}
