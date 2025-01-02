package createmode.builderpattern.demo3;

import java.util.ArrayList;
import java.util.List;

/**
 * 假设我们是一家汽车租赁公司，需要为客户提供各种不同配置的汽车。每辆汽车可以根据客户需求进行定制，包括车身颜色、内饰风格、引擎类型、附加功能等。
 * 使用建造者模式可以帮助我们更好地管理和构建这些复杂的汽车配置。
 *
 * 应用场景的特点
 * 复杂对象：汽车是一个复杂的对象，具有多个可选配置。
 * 多样性：客户可以根据自己的需求选择不同的配置组合。
 * 灵活性：我们需要能够灵活地添加新的配置选项，而不影响现有的代码。
 *
 * 通过建造者模式，我们可以轻松地构建和管理复杂的对象，特别是在需要多种配置选项的场景下。这种模式使得代码更加清晰、易于理解和维护，
 * 并且具有良好的扩展性。无论是简单的配置还是复杂的多级配置，建造者模式都能提供一种优雅的解决方案。
 */
public class Car {
    // 汽车品牌，用于标识汽车的制造商
    private String brand;
    // 车型，具体的汽车型号名称
    private String model;
    // 车身颜色，影响汽车外观
    private String bodyColor;
    // 内饰风格，如皮革、织物等
    private String interiorStyle;
    // 发动机类型，如汽油、电动、混合动力等
    private String engineType;
    // 额外的功能列表，可能包括导航、天窗等
    private List<String> additionalFeatures;
    // 是否具有自动驾驶功能
    private boolean hasAutopilot;
    // 价格，通常指汽车的售价或租赁价格等
    private double price;

    // 私有构造函数
    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.bodyColor = builder.bodyColor;
        this.interiorStyle = builder.interiorStyle;
        this.engineType = builder.engineType;
        this.additionalFeatures = builder.additionalFeatures;
        this.hasAutopilot = builder.hasAutopilot;
        this.price = builder.price;
    }

    // Getter 方法
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public String getInteriorStyle() {
        return interiorStyle;
    }

    public String getEngineType() {
        return engineType;
    }

    public List<String> getAdditionalFeatures() {
        return additionalFeatures;
    }

    public boolean hasAutopilot() {
        return hasAutopilot;
    }

    public double getPrice() {
        return price;
    }

    // 内部建造者类
    public static class Builder {
        private String brand;
        private String model;
        private String bodyColor;
        private String interiorStyle;
        private String engineType;
        private List<String> additionalFeatures;
        private boolean hasAutopilot;
        private double price;

        public Builder() {
            this.additionalFeatures = new ArrayList<>();
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setBodyColor(String bodyColor) {
            this.bodyColor = bodyColor;
            return this;
        }

        public Builder setInteriorStyle(String interiorStyle) {
            this.interiorStyle = interiorStyle;
            return this;
        }

        public Builder setEngineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public Builder addFeature(String feature) {
            this.additionalFeatures.add(feature);
            return this;
        }

        public Builder setHasAutopilot(boolean hasAutopilot) {
            this.hasAutopilot = hasAutopilot;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

