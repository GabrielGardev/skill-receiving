package interfeaces;

import enums.ReportLevel;

public interface Layout {
    String format(String time, String message, ReportLevel reportLevel);
}
