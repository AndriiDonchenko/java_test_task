package com.donch.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitingTimeline {
    private int indexNumber;
    private String serviceId;
    private String questionTypeId;
    private String responseType;
    private Date date;
    private int waitingTime;

    public WaitingTimeline(int indexNumber, String[] params) throws ParseException {
        this.indexNumber = indexNumber;
        serviceId = params[1];
        questionTypeId = params[2];
        responseType = params[3];
        date = new SimpleDateFormat("dd.MM.yyyy").parse(params[4]);
        waitingTime = Integer.parseInt(params[5]);
    }

    public String getServiceId() {
        return serviceId;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public String getResponseType() {
        return responseType;
    }

    public Date getDate() {
        return date;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

}
