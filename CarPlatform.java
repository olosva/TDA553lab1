public class CarPlatform implements Platform{
    protected int rampState;

    public CarPlatform(){
        rampState=1;
    }
    @Override
    public void raisePlatform() {
        rampState=1;
    }
    @Override
    public void lowerPlatform() {
        rampState=0;
    }
    @Override
    public boolean platformInUse() {
        if (rampState==0) {
            return true;
        } else {
            return false;
        }
    }
}
