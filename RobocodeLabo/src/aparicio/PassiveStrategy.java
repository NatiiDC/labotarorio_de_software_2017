package aparicio;

import robocode.ScannedRobotEvent;

public class PassiveStrategy implements RobottoStrategy {
  
  private AparicioRobotto robotto;
  private static int MAX_POWER = 3;
  private static int LEFT = 0;
  private static int UP = 90;
  private static int RIGTH = 180;
  private static int DOWN = 270;
  
  PassiveStrategy(AparicioRobotto robotto) {
    this.robotto = robotto;
  }
  
  @Override
  public void onScannedRobot() {
    
    int grados = this.robotto.scannedBearing;
    this.robotto.bearGunTo(grados);
    if (this.robotto.scannedBearing == 0) {
      this.robotto.fire(MAX_POWER);
      this.robotto.turnBackRight(15, RIGTH);
      grados = this.robotto.scannedBearing;
      this.robotto.bearGunTo(grados);
      this.robotto.fire(MAX_POWER);
    }
    
  }
  
  @Override
  public void onHitByBullet() {
    this.onHitRobot();
    this.robotto.setStrategy(new AtackedStrategy(this.robotto));
  }
  
  @Override
  public void onHitWall() {
    this.robotto.ahead(35);
  }
  
  @Override
  public void onHitRobot() {
    int grados = this.robotto.hitByBulletBearing;
    this.robotto.bearGunTo(grados);
    this.robotto.fire(MAX_POWER);
    this.robotto.fire(MAX_POWER);
    this.robotto.fire(MAX_POWER);
  }
  
  @Override
  public void run() {
    this.robotto.turnBackRight(80, 90);
    this.robotto.turnAheadRight(80, 90);
  }
  
  @Override
  public void checkEnergy() {
  
  }
}
