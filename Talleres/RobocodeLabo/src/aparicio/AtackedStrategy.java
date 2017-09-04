package aparicio;

public class AtackedStrategy implements RobottoStrategy {
  
  private AparicioRobotto robotto;
  private int distanceH;
  private int distanceW;
  private static int MAX_POWER = 3;
  private static int LEFT = 0;
  private static int UP = 90;
  private static int RIGTH = 180;
  private static int DOWN = 270;
  
  AtackedStrategy(AparicioRobotto robotto) {
    this.robotto = robotto;
    this.distanceH = robotto.fieldHeight;
    this.distanceW = robotto.fieldWidth;
  }
  
  @Override
  public void onScannedRobot() {
    int grados = this.robotto.scannedAngle;
    this.robotto.bearGunTo(grados);
    this.robotto.fire(MAX_POWER);
  }
  
  @Override
  public void onHitByBullet() {
    this.onHitRobot();
  
  }
  
  @Override
  public void onHitWall() {
    this.robotto.back(35);
    this.robotto.turnRight(90);
  }
  
  @Override
  public void onHitRobot() {
    int grados = this.robotto.hitByBulletBearing;
    this.robotto.bearGunTo(grados);
    this.robotto.fire(MAX_POWER);
  }
  
  @Override
  public void run() {
    this.robotto.turnBackRight(80, 90);
    this.robotto.turnAheadRight(80, 90);
    
    int grados = this.robotto.scannedAngle;
    this.robotto.turnTo(grados);
    this.robotto.bearGunTo(grados);
    this.robotto.fire(1);
    
    if (this.robotto.energy < 30) {
      this.robotto.setStrategy(new PassiveStrategy(this.robotto));
    }
  }
  
  @Override
  public void checkEnergy() {
  
  }
  
}
