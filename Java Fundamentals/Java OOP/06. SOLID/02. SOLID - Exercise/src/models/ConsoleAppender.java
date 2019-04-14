package models;

import enums.ReportLevel;
import interfeaces.Appender;
import interfeaces.Layout;

public class ConsoleAppender extends AppenderImpl {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel){
        super(layout, reportLevel   );
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        super.incrementMessagesCount();
        if (this.canAppend(reportLevel)) {
            String output = this.getLayout().format(time, message, reportLevel);
            System.out.println(output);
        }
    }
}
