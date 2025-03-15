package com.example.userservice.service;

import com.example.userservice.domain.req.DateDifferenceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class DateService {

    public ResponseEntity<Object> calculateDateDifference(DateDifferenceRequest request) {
        try {
            DateTool tool = new DateTool();
            LocalDate targetDate = tool.parseDate(request.getTargetDate());
            LocalDate currentDate = tool.getCurrentDate();
            long dif = tool.getDaysDifference(currentDate, targetDate);
            return ResponseEntity.ok(dif);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Please use yyyy-MM-dd format");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


} 