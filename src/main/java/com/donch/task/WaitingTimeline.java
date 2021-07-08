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

    public WaitingTimeline(int indexNumber, String[] timelineParams) throws ParseException {
        this.indexNumber = indexNumber;
        serviceId = timelineParams[1];
        questionTypeId = timelineParams[2];
        responseType = timelineParams[3];
        date = new SimpleDateFormat("dd.MM.yyyy").parse(timelineParams[4]);
        waitingTime = Integer.parseInt(timelineParams[5]);
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
