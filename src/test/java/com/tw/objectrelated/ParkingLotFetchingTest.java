package com.tw.objectrelated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ParkingLotFetchingTest {
    private ParkingLot createParkingLotWithPlentyOfCapacity() {
        return ParkingLotFactory.create(1000);
    }

    @Test
    void should_return_the_parked_car_using_ticket() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        final Car car = new Car();
        final ParkingTicket ticket = parkingLot.park(car);

        // When
        final Car fetched = parkingLot.fetch(ticket);

        // Then
        assertSame(car, fetched);
    }

    @Test
    void should_return_the_parked_car_correspond_to_the_ticket() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        final Car firstCar = new Car();
        final Car secondCar = new Car();
        final ParkingTicket firstTicket = parkingLot.park(firstCar);
        final ParkingTicket secondTicket = parkingLot.park(secondCar);

        // When
        final Car fetchedSecond = parkingLot.fetch(secondTicket);
        final Car fetchedFirst = parkingLot.fetch(firstTicket);

        // Then
        assertSame(secondCar, fetchedSecond);
        assertSame(firstCar, fetchedFirst);
    }

    @Test
    void should_fail_if_ticket_is_null() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        parkingLot.park(new Car());

        // When
        final Car fetched = parkingLot.fetch(null);

        // Then
        assertNull(fetched);
        assertEquals("No ticket is provided.", parkingLot.getLastErrorMessage());
    }

    @Test
    void should_fail_if_ticket_has_been_used() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        final ParkingTicket ticket = parkingLot.park(new Car());
        parkingLot.fetch(ticket);

        // When
        final Car fetched = parkingLot.fetch(ticket);

        // Then
        assertNull(fetched);
        assertEquals("Invalid ticket.", parkingLot.getLastErrorMessage());
    }

    @Test
    void should_fail_if_ticket_matches_no_car() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        parkingLot.park(new Car());

        // When
        final Car fetched = parkingLot.fetch(new ParkingTicket());

        // Then
        assertNull(fetched);
        assertEquals("Invalid ticket.", parkingLot.getLastErrorMessage());
    }

    @Test
    void should_update_position_on_fetching_success() {
        // Given
        final ParkingLot parkingLot = createParkingLotWithPlentyOfCapacity();
        final ParkingTicket ticket = parkingLot.park(new Car());
        final int positions = parkingLot.getAvailableParkingPosition();

        // When
        parkingLot.fetch(ticket);

        // Then
        assertEquals(positions, parkingLot.getAvailableParkingPosition() - 1);
    }
}
