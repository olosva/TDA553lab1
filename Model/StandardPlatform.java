public class StandardPlatform implements Platform{

    private double angleOfPlatform;

    public StandardPlatform(){
        angleOfPlatform=0;
    }
    @Override
    public void raisePlatform() {
        this.changeAngleOfPlatform(1);
    }

    @Override
    public void lowerPlatform() {
        this.changeAngleOfPlatform(-1);
    }
    private void changeAngleOfPlatform(double degree){
        if (angleOfPlatform + degree <= 70 && angleOfPlatform + degree >= 0) {
            angleOfPlatform += degree;
        } else {
            throw new IllegalArgumentException("Platform angle out of range");
        }
    }
    @Override
    public double getPlatformLevel() {
        return angleOfPlatform;
    }

    @Override
    public boolean platformInUse() {
        if (angleOfPlatform != 0) {
            return true;
        } else {
            return false;
        }
    }
}
