package com.donch.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Query {
    private int indexNumber;
    private String serviceId;
    private String questionTypeId;
    private String responseType;
    private Date dateFrom;
    private Date dateTo;

    public Query(int indexNumber, String[] queryParams) throws ParseException {
        this.indexNumber = indexNumber;
        serviceId = queryParams[1];
        questionTypeId = queryParams[2];
        responseType = queryParams[3];

        String[] dates = queryParams[4].split("-");
        dateFrom = new SimpleDateFormat("dd.MM.yyyy").parse(dates[0]);

        if(dates.length == 2)
            dateTo = new SimpleDateFormat("dd.MM.yyyy").parse(dates[1]);
    }

    public boolean matcher(WaitingTimeline wtl) {
        if (wtl.getIndexNumber() > indexNumber
                || idMatcher(serviceId, wtl.getServiceId())
                || idMatcher(questionTypeId, wtl.getQuestionTypeId())
                || !(wtl.getResponseType().equals(responseType))
                || dateMatcher(wtl.getDate())
        ) return false;

        return true;
    }

    private boolean idMatcher(String queryId, String waitingTimelineId) {
        if(queryId.equals("*") || Arrays.stream(waitingTimelineId.split("\\.")).findFirst()
                .equals(Arrays.stream(queryId.split("\\.")).findFirst())) {
            return false;
        }

        return true;
    }

    private boolean dateMatcher(Date waitingTimelineDate) {
        return (dateTo != null && !(waitingTimelineDate.after(dateFrom) && waitingTimelineDate.before(dateTo))
                || dateTo == null && !(waitingTimelineDate.after(dateFrom)));
    }

}
