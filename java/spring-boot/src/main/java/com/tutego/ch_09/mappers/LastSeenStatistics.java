package com.tutego.ch_09.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.YearMonth;
import java.util.List;

public record LastSeenStatistics(List<Data> data) {
    record Data(@JsonProperty("x") YearMonth yearMonth, @JsonProperty("y") int count) {}
}
