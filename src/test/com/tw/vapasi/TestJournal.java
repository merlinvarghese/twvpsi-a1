package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TestJournal {

  @Test
  void expectExactPersonNamesForJournalEntries() {
    ArrayList<Entry> list = new ArrayList<Entry>();
    list.add(new Entry("A", 100.0));
    list.add(new Entry("B", 200.0));
    Journal journal = new Journal();
    journal.addMultipleEntries(list);
    Arrays.stream(journal.getParticipants()).forEach(e -> System.out.println("*" + e + "*,"));
    assertArrayEquals(new String[]{"A","B"}, journal.getParticipants());
  }

  @Test
  void expectNoPersonNamesForEmptyJournal() {
    Journal journal = new Journal();
    assertArrayEquals(new String[]{}, journal.getParticipants());
  }

  @Test
  void expect0ForAToGiveWhenJournalEmpty() {
    Journal journal = new Journal();
    assertEquals(0.0, journal.getPersonalExpense("A"));
  }

  @Test
  void expect200ForBToGive() {
    ArrayList<Entry> list = new ArrayList<Entry>();
    list.add(new Entry("A", 100.0));
    list.add(new Entry("B", 200.0));
    Journal journal = new Journal();
    journal.addMultipleEntries(list);
    assertEquals(200.0, journal.getPersonalExpense("B"));
  }

  @Test
  void expect100ForAToGet() {
    ArrayList<Entry> list = new ArrayList<Entry>();
    list.add(new Entry("A", -100.0));
    list.add(new Entry("B", 200.0));
    Journal journal = new Journal();
    journal.addMultipleEntries(list);
    assertEquals(-100.0, journal.getPersonalExpense("A"));
  }

}
