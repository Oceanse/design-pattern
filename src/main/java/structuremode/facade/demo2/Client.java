package structuremode.facade.demo2;

/**
 * 我们将以一个在线旅游预订平台为例，该平台需要集成酒店预订、航班预订和租车服务等多个子系统。
 * 我们将通过门面模式来提供一个统一的接口来封装多个子系统的功能，并提供一个简单的入口点,
 * 使得用户可以通过简单的调用来完成复杂的预订流程。
 *
 * 优点:
 * 简化客户端代码：客户端只需要调用门面类的一个方法即可完成复杂的预订流程，而不必直接与多个子系统交互。
 * 降低耦合度：门面类将客户端与子系统解耦，使得客户端不必关心子系统的具体实现细节。
 * 易于维护：子系统的修改不会影响到客户端代码，因为客户端只与门面类交互。
 * 提高安全性：门面类可以作为系统的安全边界，控制对外暴露的接口，防止外部代码直接访问子系统。
 */
public class Client {
    public static void main(String[] args) {
        // 创建子系统实例
        HotelReservation hotelReservation = new HotelReservationImpl();
        FlightReservation flightReservation = new FlightReservationImpl();
        CarRentalService carRentalService = new CarRentalServiceImpl();

        // 创建门面对象
        TravelBookingFacade facade = new TravelBookingFacade(hotelReservation, flightReservation, carRentalService);

        // 客户端调用门面接口
        boolean tripBooked = facade.bookTrip("hotel123", "2024-09-01", "2024-09-05",
                "flight456", "2024-09-01",
                "car789", "2024-09-01", "2024-09-05");

        System.out.println("Trip booked: " + tripBooked);
    }
}
