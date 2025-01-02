package structuremode.facade.demo2;

/**
 * 航班预订子系统接口
 */
public interface FlightReservation {
    boolean bookFlight(String flightId, String departureDate);
}


/**
 * 航班预订子系统实现
 */
 class FlightReservationImpl implements FlightReservation {
    @Override
    public boolean bookFlight(String flightId, String departureDate) {
        System.out.println("Booking flight " + flightId + " on " + departureDate);
        // 假设预订成功
        return true;
    }
}