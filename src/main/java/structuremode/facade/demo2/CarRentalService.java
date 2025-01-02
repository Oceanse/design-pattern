package structuremode.facade.demo2;


/**
 * 租车服务子系统接口
 */
public interface CarRentalService {
    boolean rentCar(String carId, String rentalStartDate, String rentalEndDate);
}

/**
 * 租车服务子系统实现
 */
 class CarRentalServiceImpl implements CarRentalService {
    @Override
    public boolean rentCar(String carId, String rentalStartDate, String rentalEndDate) {
        System.out.println("Renting car " + carId + " from " + rentalStartDate + " to " + rentalEndDate);
        // 假设租车成功
        return true;
    }
}