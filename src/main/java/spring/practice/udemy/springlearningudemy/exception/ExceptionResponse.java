package spring.practice.udemy.springlearningudemy.exception;

import java.util.Date;


public class ExceptionResponse {
    Date date;
    String message;
    String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExceptionResponse{" +
                "date=" + date +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
