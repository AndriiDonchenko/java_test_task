package com.donch.task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataAnalyticsTool {
    List<Query> queries = new ArrayList<>();
    List<WaitingTimeline> waitingTimelines = new ArrayList<>();

    public void evaluate(String filepath) {
        String input = Util.getInput(filepath);
        String[] inputLines = Arrays.stream(input.split(System.lineSeparator()))
                .skip(1)
                .toArray(String[]::new);

        inputDataProcessing(inputLines);

        System.out.print(getEvaluationResults());
    }

    private void inputDataProcessing(String[] inputLines) {
        try {
            for (int i = 0; i < inputLines.length; i++) {
                if (inputLines[i].charAt(0) == 'C') {
                    waitingTimelines.add(new WaitingTimeline(i, inputLines[i].split(" ")));
                } else {
                    queries.add(new Query(i, inputLines[i].split(" ")));
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String getEvaluationResults() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Query query : queries) {
            int totalWaitingTime = 0;
            int matchersCounter = 0;

            for(WaitingTimeline wtl : waitingTimelines) {
                if(query.matcher(wtl)) {
                    matchersCounter ++;
                    totalWaitingTime += wtl.getWaitingTime();
                }
            }

            stringBuilder.append(matchersCounter != 0 ? totalWaitingTime/matchersCounter : "-")
                         .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }
}
