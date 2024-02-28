public class Factory {
    public static Volvo240 createVolvo240() {
        return new Volvo240();
    }
    public static Saab95 createSaab95() {
        return new Saab95();
    }
    public static Scania createScania() {
        return new Scania();
    }
    public static WorkShop<Volvo240> createVolvoWorkShop(int maxcars, int xpos, int ypos) {
        return new WorkShop<Volvo240>(maxcars, xpos, ypos);
    }
}
