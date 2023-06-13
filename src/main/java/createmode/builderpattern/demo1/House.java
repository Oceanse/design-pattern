package createmode.builderpattern.demo1;

/**
 * Product（产品角色）：它是被构建的复杂对象，包含多个组成部件，具体建造者Builder负责创建该产品的具体步骤
 */
public class House {
    /**
     * 地基
     */
    private String basic;

    /**
     * 墙
     */
    private String walls;

    /**
     * 封顶
     */
    private String roofed;

    /**
     * Gets the value of basic
     *
     * @return the value of basic
     */
    public String getBasic() {
        return basic;
    }

    /**
     * Sets the basic
     *
     * @param basic basic
     */
    public void setBasic(String basic) {
        this.basic = basic;
    }

    /**
     * Gets the value of walls
     *
     * @return the value of walls
     */
    public String getWalls() {
        return walls;
    }

    /**
     * Sets the walls
     *
     * @param walls walls
     */
    public void setWalls(String walls) {
        this.walls = walls;
    }

    /**
     * Gets the value of roofed
     *
     * @return the value of roofed
     */
    public String getRoofed() {
        return roofed;
    }

    /**
     * Sets the roofed
     *
     * @param roofed roofed
     */
    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    @Override
    public String toString() {
        return "House{" +
                "basic='" + basic + '\'' +
                ", walls='" + walls + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }
}
