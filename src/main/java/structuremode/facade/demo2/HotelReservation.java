package structuremode.facade.demo2;

/**
 * 酒店预订子系统接口
 */
public interface HotelReservation {
    boolean bookHotel(String hotelId, String checkInDate, String checkOutDate);
}

/**
 * 酒店预订子系统实现
 */
 class HotelReservationImpl implements HotelReservation {
    @Override
    public boolean bookHotel(String hotelId, String checkInDate, String checkOutDate) {
        System.out.println("Booking hotel " + hotelId + " from " + checkInDate + " to " + checkOutDate);
        // 假设预订成功
        return true;
    }
}