package com.tw.vapasi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Understands jourrnal entries per user per expense
public class Journal {

  private ArrayList<Entry> entries = new ArrayList<Entry>();
  
  public void addMultipleEntries(List<Entry> entries) {
    this.entries.addAll(entries);
  }

  public Double getPersonalExpense(String personName) {
    Double totalExpense = 0.0;
    for (Entry entry: entries) {
      if(personName.equals(entry.getPersonName()))
        totalExpense += entry.getAmount();
    }
    return totalExpense;
  }

  public String[] getParticipants() {
    Set<String> participants = new HashSet<String>();
    for (Entry entry: entries) {
      participants.add(entry.getPersonName());
    }

    return participants.toArray(new String[participants.size()]);
  }

  @Override
  public String toString() {
    return entries.toString();
  }
}
