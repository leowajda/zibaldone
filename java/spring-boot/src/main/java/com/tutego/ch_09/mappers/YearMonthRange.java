package com.tutego.ch_09.mappers;

import java.time.YearMonth;

// WebDataBinder can manipulate beans, invokes the ConversionService recursively
public class YearMonthRange {
    private YearMonth start, end;


    public YearMonth getStart() {
        return start;
    }

    public void setStart(YearMonth start) {
        this.start = start;
    }

    public YearMonth getEnd() {
        return end;
    }

    public void setEnd(YearMonth end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "YearMonthRange[start='%s', end='%s']".formatted(start, end);
    }
}
