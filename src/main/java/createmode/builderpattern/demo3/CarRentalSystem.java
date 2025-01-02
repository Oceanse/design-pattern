package createmode.builderpattern.demo3;

public class CarRentalSystem {
    public static void main(String[] args) {
        // 创建一辆豪华配置的租赁汽车
        Car luxuryCar = new Car.Builder()
                .setBrand("Mercedes-Benz")
                .setModel("S-Class")
                .setBodyColor("Black")
                .setInteriorStyle("Premium Leather")
                .setEngineType("V8 Hybrid")
                .addFeature("Panoramic Sunroof")
                .addFeature("Burmester Sound System")
                .setHasAutopilot(true)
                .setPrice(5000.00) // 每月租金
                .build();

        System.out.println("Luxury Car Rental:");
        System.out.println("Brand: " + luxuryCar.getBrand());
        System.out.println("Model: " + luxuryCar.getModel());
        System.out.println("Body Color: " + luxuryCar.getBodyColor());
        System.out.println("Interior Style: " + luxuryCar.getInteriorStyle());
        System.out.println("Engine Type: " + luxuryCar.getEngineType());
        System.out.println("Additional Features: " + luxuryCar.getAdditionalFeatures());
        System.out.println("Has Autopilot: " + luxuryCar.hasAutopilot());
        System.out.println("Monthly Rent: $" + luxuryCar.getPrice());

        // 创建一辆经济配置的租赁汽车
        Car economyCar = new Car.Builder()
                .setBrand("Toyota")
                .setModel("Corolla")
                .setBodyColor("White")
                .setInteriorStyle("Cloth")
                .setEngineType("Four-Cylinder")
                .addFeature("USB Port")
                .setHasAutopilot(false)
                .setPrice(1000.00) // 每月租金
                .build();

        System.out.println("\nEconomy Car Rental:");
        System.out.println("Brand: " + economyCar.getBrand());
        System.out.println("Model: " + economyCar.getModel());
        System.out.println("Body Color: " + economyCar.getBodyColor());
        System.out.println("Interior Style: " + economyCar.getInteriorStyle());
        System.out.println("Engine Type: " + economyCar.getEngineType());
        System.out.println("Additional Features: " + economyCar.getAdditionalFeatures());
        System.out.println("Has Autopilot: " + economyCar.hasAutopilot());
        System.out.println("Monthly Rent: $" + economyCar.getPrice());
    }
}