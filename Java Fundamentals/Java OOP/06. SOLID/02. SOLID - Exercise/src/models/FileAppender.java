package models;

import enums.ReportLevel;
import interfeaces.Appender;
import interfeaces.File;
import interfeaces.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        super.incrementMessagesCount();
        if (this.file == null){
            throw new IllegalCallerException("File not set!");
        }
        if (this.canAppend(reportLevel)) {
            this.file.append(this.getLayout().format(time, message, reportLevel));
            this.file.write();
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", this.file.getSize());
    }
}
