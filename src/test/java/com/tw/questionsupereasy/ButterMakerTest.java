package com.tw.questionsupereasy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButterMakerTest {
    @Test
    void should_throw_if_numbers_of_pieces_is_small_than_0() {
        assertThrows(IllegalArgumentException.class, () -> ButterMaker.getSmallButterUsage(-1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> ButterMaker.getSmallButterUsage(1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> ButterMaker.getSmallButterUsage(1, 1, -1));
        assertThrows(IllegalArgumentException.class, () -> ButterMaker.getSmallButterUsage(-1, -1, 0));
    }

    @Test
    void should_work_for_normal_cases() {
        assertEquals(4, ButterMaker.getSmallButterUsage(4, 1, 9));
        assertEquals(-1, ButterMaker.getSmallButterUsage(4, 1, 10));
        assertEquals(2, ButterMaker.getSmallButterUsage(4, 1, 7));
        assertEquals(2, ButterMaker.getSmallButterUsage(6, 2, 7));
        assertEquals(0, ButterMaker.getSmallButterUsage(4, 1, 5));
        assertEquals(4, ButterMaker.getSmallButterUsage(4, 1, 4));
        assertEquals(4, ButterMaker.getSmallButterUsage(5, 4, 9));
        assertEquals(3, ButterMaker.getSmallButterUsage(9, 3, 18));
        assertEquals(-1, ButterMaker.getSmallButterUsage(3, 1, 9));
        assertEquals(-1, ButterMaker.getSmallButterUsage(1, 2, 7));
        assertEquals(1, ButterMaker.getSmallButterUsage(1, 2, 6));
        assertEquals(0, ButterMaker.getSmallButterUsage(1, 2, 5));
        assertEquals(5, ButterMaker.getSmallButterUsage(6, 1, 10));
        assertEquals(6, ButterMaker.getSmallButterUsage(6, 1, 11));
        assertEquals(-1, ButterMaker.getSmallButterUsage(6, 1, 12));
        assertEquals(-1, ButterMaker.getSmallButterUsage(6, 1, 13));
        assertEquals(0, ButterMaker.getSmallButterUsage(6, 2, 10));
        assertEquals(1, ButterMaker.getSmallButterUsage(6, 2, 11));
        assertEquals(2, ButterMaker.getSmallButterUsage(6, 2, 12));
        assertEquals(50, ButterMaker.getSmallButterUsage(60, 100, 550));
        assertEquals(6, ButterMaker.getSmallButterUsage(1000, 1000000, 5000006));
        assertEquals(7, ButterMaker.getSmallButterUsage(7, 1, 12));
        assertEquals(-1, ButterMaker.getSmallButterUsage(7, 1, 13));
        assertEquals(3, ButterMaker.getSmallButterUsage(7, 2, 13));
    }
}
