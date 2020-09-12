package com.tw.objectRelated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTestParking {
    private ParkingLot createParkingLotWithPlentyOfCapacity() {
        return ParkingLotFactory.create(1000);
    }

    private ParkingLot createFullParkingLot() {
        final int capacity = 10;
        final ParkingLot parkingLot = ParkingLotFactory.create(capacity);
        for (int i = 0; i < capacity; ++i) {
            parkingLot.park(new Car());
        }

        return parkingLot;
    }

    @Test
    void should_return_a_not_null_ticket_when_parking_operation_is_successful() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();

        // When
        final ParkingTicket ticket = parkingLot.park(new Car());

        // Then
        assertNotNull(ticket);
    }

    @Test
    void should_be_able_to_fill_parking_lot_with_cars() {
        // Given
        final int capacity = 10;
        final ParkingLot parkingLot = ParkingLotFactory.create(capacity);

        for (int i = 0; i < capacity; ++ i) {
            // When
            final ParkingTicket ticket = parkingLot.park(new Car());

            // Then
            assertNotNull(ticket);
        }
    }

    @Test
    void should_fail_when_you_want_to_park_nothing() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();

        // When
        final ParkingTicket ticket = parkingLot.park(null);

        // Then
        assertNull(ticket);
        assertEquals("You are parking nothing.", parkingLot.getLastErrorMessage());
    }

    @Test
    void should_fail_when_car_is_parked_twice() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        final Car car = new Car();
        parkingLot.park(car);

        // When
        final ParkingTicket ticket = parkingLot.park(car);

        // Then
        assertNull(ticket);
        assertEquals("The car has been parked.", parkingLot.getLastErrorMessage());
    }

    @Test
    void should_fail_when_there_is_not_enough_position() {
        // Given
        final ParkingLot fullParkingLot = createFullParkingLot();

        // When
        final ParkingTicket ticket = fullParkingLot.park(new Car());

        // Then
        assertNull(ticket);
        assertEquals("The parking lot is full.", fullParkingLot.getLastErrorMessage());
    }

    @Test
    void should_update_position_on_parking_success() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        final int initialPositions = parkingLot.getAvailableParkingPosition();

        // When
        parkingLot.park(new Car());

        // Then
        assertEquals(initialPositions, parkingLot.getAvailableParkingPosition() + 1);
    }
}