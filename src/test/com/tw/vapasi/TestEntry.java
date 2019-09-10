package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestEntry {
  @Test
  void expectNotEqualsForDifferentEntries() {
    Entry firstEntry = new Entry("A", 100.0);
    Entry secondEntry = new Entry("B", 200.0);
    assertFalse(firstEntry.equals(secondEntry));
  }

  @Test
  void expectEqualsForSameEntries() {
    Entry firstEntry = new Entry("A", 100.0);
    Entry secondEntry = new Entry("A", 100.0);
    assertTrue(firstEntry.equals(secondEntry));
  }
}
