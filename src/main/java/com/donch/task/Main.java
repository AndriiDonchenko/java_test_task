package com.donch.task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        String input = Util.getInput("input.txt");

        String[] inputLines = Arrays.stream(input.split(System.lineSeparator())).skip(1).toArray(String[]::new);

        List<Query> queries = new ArrayList<>();
        List<WaitingTimeline> waitingTimelines = new ArrayList<>();

        for(int i = 0; i < inputLines.length; i++) {
            if(inputLines[i].charAt(0) == 'C') {
                waitingTimelines.add(new WaitingTimeline(i, inputLines[i].split(" ")));
            } else {
                queries.add(new Query(i, inputLines[i].split(" ")));
            }
        }

        for(Query query : queries) {
            int totalWaitingTime = 0;
            int matchersCounter = 0;

            for(WaitingTimeline wtl : waitingTimelines) {
                if(query.matcher(wtl)) {
                    matchersCounter ++;
                    totalWaitingTime += wtl.getWaitingTime();
                }
            }
            System.out.println(matchersCounter != 0 ? Math.round(totalWaitingTime/matchersCounter) : "-");
        }

    }
}
