package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {

        super(emailId, Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.
this.calendar=new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
//int c=1;

int n = calendar.size();

        ArrayList<pair> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new pair(calendar.get(i).getStartTime(),calendar.get(i).getEndTime()));
        }
        Collections.sort(list);
        int cnt=1;
        LocalTime prev=list.get(0).end;
        for(int i=1;i<n;i++) {
            if(list.get(i).strt.compareTo(prev)>0)   {
                cnt++;
                prev=list.get(i).end; }
        }
        return cnt;
    }
}
class pair implements Comparable<pair>{
    LocalTime strt;
    LocalTime end;
    public pair(LocalTime strt,LocalTime end) {
        this.strt=strt;
        this.end=end;
    }
    public int compareTo(pair p)  {
        if(this.end.compareTo(p.end)>0)
            return 1;
        else
            return -1;
    }
}
