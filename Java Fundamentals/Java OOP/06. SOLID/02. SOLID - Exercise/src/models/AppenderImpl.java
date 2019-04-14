package models;

import enums.ReportLevel;
import interfeaces.Appender;
import interfeaces.Layout;

public abstract class AppenderImpl implements Appender {
    public static final ReportLevel REPORT_LEVEL_DEFAULT = ReportLevel.INFO;

    private Layout layout;
    private int messagesCount;
    private ReportLevel reportLevel;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = AppenderImpl.REPORT_LEVEL_DEFAULT;
        this.messagesCount = 0;
    }

    protected void incrementMessagesCount(){
        ++this.messagesCount;
    }
    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public abstract void append(String time, String message, ReportLevel reportLevel);


    public AppenderImpl(Layout layout, ReportLevel reportLevel){
        this(layout);
        this.reportLevel = reportLevel;
    }

    public Layout getLayout() {
        return layout;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected boolean canAppend(ReportLevel reportLevel){
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s," +
                " Layout type: %s," +
                " Report level: %s," +
                " Messages appended: %d", this.getClass().getSimpleName(), this.layout.getClass(),
                this.reportLevel.toString(), this.messagesCount);
    }
}
