package aparicio;

public interface RobottoStrategy {
  public void onScannedRobot();
  public void onHitByBullet();
  public void onHitWall();
  public void onHitRobot();
  public void run();
  public void checkEnergy();
  
}
