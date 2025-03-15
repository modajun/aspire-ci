package com.example.userservice.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateTool {
    public long calculateDays(String targetDateStr) {
        LocalDate targetDate = parseDate(targetDateStr);
        LocalDate currentDate = getCurrentDate();
        return getDaysDifference(currentDate, targetDate);
    }

    public LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr);
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public long getDaysDifference(LocalDate date1, LocalDate date2) {
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }
}
