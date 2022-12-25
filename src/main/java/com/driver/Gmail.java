package com.driver;

import java.util.*;

public class Gmail extends Email {
//TreeMap<Date,String> map = new TreeMap<>();
Stack<Date> st = new Stack<>();
List<Pair> list = new ArrayList<>();
class Pair{
    Date d;
    String mssg;
    Pair(Date d,String mssg){
        this.mssg=mssg;
        this.d=d;

    }
}
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
super(emailId);
this.inboxCapacity=inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        int inboxSize = getInboxSize();
        int capacity = getInboxCapacity();

//        if(inboxSize<capacity){
//            map.put(date,message);
//        }else
          if(inboxSize==capacity){
            Date remove=date;

            list.remove(0);
           // map.remove(remove);

            st.push(remove);
           // map.put(date,message);
        }
          list.add(new Pair(date,message));
      //  map.put(date,message);
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
//for(Date d : map.keySet()){
//    if(map.get(d).equals(message)){
//        System.out.println("this is the deleted msg "+map.get(d));
//        map.remove(d);
//        st.push(d);
//        break;
//    }
//}
        int size = getInboxSize();
        if(size==0)
            return;

for(int i=0;i<list.size();i++){
    if(list.get(i).mssg.equals(message)){
        list.remove(i);
        st.push(list.get(i).d);
        break;
    }
}
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        int size = getInboxSize();
        if(size==0)
            return null;
//        String last ="";
//        for(Date d : map.keySet()){
//last = map.get(d);
//        }
        Pair p = list.get(list.size()-1);
return p.mssg;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        int size = getInboxSize();
        if(size==0)
            return null;
//        String last ="";
//        for(Date d : map.keySet()){
//            last = map.get(d);
//            break;
//        }
        Pair p = list.get(0);
        return p.mssg;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
int total=0;
//for(Date d: map.keySet()){
//    if(d.compareTo(start)>=0 && d.compareTo(end)<=0)
//        total++;
//}
        for(Pair p : list){
            if(p.d.compareTo(start)>=0 && p.d.compareTo(end)<=0)
                total++;
        }
return total;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
int size = list.size();
return size;
    }

    public int getTrashSize(){
        // Return number of mails in Trash
int size = st.size();
return size;
    }

    public void emptyTrash(){
        // clear all mails in the trash
int n = st.size();
for(int i=0;i<n;i++)
    st.pop();

    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}
