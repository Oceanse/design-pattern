package structuremode.facade.demo2;

/**
 * 门面类
 * 封装了各个子系统的功能，提供了 bookTrip 方法来统一处理预订流程
 */
public class TravelBookingFacade {
    private final HotelReservation hotelReservation;
    private final FlightReservation flightReservation;
    private final CarRentalService carRentalService;

    public TravelBookingFacade(HotelReservation hotelReservation,
                               FlightReservation flightReservation,
                               CarRentalService carRentalService) {
        this.hotelReservation = hotelReservation;
        this.flightReservation = flightReservation;
        this.carRentalService = carRentalService;
    }

    public boolean bookTrip(String hotelId, String checkInDate, String checkOutDate,
                            String flightId, String departureDate,
                            String carId, String rentalStartDate, String rentalEndDate) {
        boolean hotelBooked = hotelReservation.bookHotel(hotelId, checkInDate, checkOutDate);
        boolean flightBooked = flightReservation.bookFlight(flightId, departureDate);
        boolean carRented = carRentalService.rentCar(carId, rentalStartDate, rentalEndDate);

        if (hotelBooked && flightBooked && carRented) {
            System.out.println("Trip booked successfully.");
            return true;
        } else {
            System.out.println("Failed to book trip.");
            return false;
        }
    }
}