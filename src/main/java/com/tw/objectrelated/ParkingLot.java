package com.tw.objectrelated;

/**
 * The parking lot can park and fetch cars.
 */
public interface ParkingLot {
    /**
     * <p>This method will park the given car to this {@link ParkingLot }.</p>
     *
     * <p>Each car will use only one space in the parking lot. If the parking lot is not fully
     * filled, then you should always be able to park a car into it.</p>
     *
     * <p>If the parking operation is successful. Then the method should return a non-null
     * {@link ParkingTicket}. And there should not be any error message. But if the parking
     * operation failed, the method should return a null {@link ParkingTicket} and set the
     * error message. Please note that it should completely cancel the operation when the
     * operation failed.</p>
     *
     * <p>The following operations will fail the parking process: </p>
     * <ul>
     *     <li>When the car is null. The error message is: {@code "You are parking nothing."}</li>
     *     <li>When the car is parked twice. The error message is: {@code "The car has been parked."}</li>
     *     <li>When the parking lot has no empty space. The error message is: {@code "The parking lot is full."}</li>
     * </ul>
     *
     * @param car The car to park.
     * @return The parking ticket object. Or null if parking process failed.
     */
    ParkingTicket park(Car car);

    /**
     * <p>This method fetches car from the parking lot, using the ticket provided.
     * After fetching the car, the car will no longer exist in the parking lot.</p>
     *
     * <p>If the fetching process is successful, the return value should be the car
     * correspond to the {@link ParkingTicket}. And there should be no error message.</p>
     *
     * <p>If the fetching process failed. The returned car is {@code null}. You can get
     * error message using {@link ParkingLot#getLastErrorMessage()} method. The fetching
     * process should be completely cancelled if it is failed.</p>
     *
     * <p>The following operations will fail the fetching process: </p>
     * <ul>
     *     <li>If the ticket is {@code null}. The error message should be {@code "No ticket is provided."}</li>
     *     <li>If the ticket has been used. The error message should be {@code "Invalid ticket."}</li>
     *     <li>If the ticket matches no car. The error message should be {@code "Invalid ticket."}</li>
     * </ul>
     *
     * @param ticket The ticket you get when parking the car.
     * @return The car correspond to the ticket. Or null if the process failed.
     */
    Car fetch(ParkingTicket ticket);

    /**
     * This method returns the error message to the last operation. If the last operation
     * is successful, it should return {@code null}.
     *
     * @return The error message of the last operation. Or {@code null} when there is no
     * error.
     */
    String getLastErrorMessage();

    /**
     * This method returns the available parking position count. This number will always greater
     * than or equal to zero. If it returns zero, it means no parking position left.
     *
     * @return The available parking position count.
     */
    int getAvailableParkingPosition();
}
