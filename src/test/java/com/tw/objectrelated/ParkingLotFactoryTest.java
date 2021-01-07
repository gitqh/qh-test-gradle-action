package com.tw.objectrelated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotFactoryTest {
    @Test
    void should_throw_if_capacity_is_less_than_or_equal_to_zero() {
        assertInvalidCapacity(0, "Capacity should be greater than 0: 0");
        assertInvalidCapacity(-1, "Capacity should be greater than 0: -1");
    }

    @Test
    void should_throw_if_capacity_is_greater_than_maximum() {
        assertInvalidCapacity(2001, "Capacity should be less than or equal to 2000: 2001");
    }

    @Test
    void should_create_parking_lot() {
        assertNotNull(ParkingLotFactory.create(1));
        assertNotNull(ParkingLotFactory.create(2000));
    }

    @Test
    void assertInvalidCapacity(int capacity, String expectedMessage) {
        final IllegalArgumentException exception =
            assertThrows(IllegalArgumentException.class, () -> ParkingLotFactory.create(capacity));
        assertEquals(expectedMessage, exception.getMessage());
    }
}
