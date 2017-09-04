package aparicio;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html


public class AparicioRobotto extends JuniorRobot {
  
  private RobottoStrategy strategy;
  
  @Override
	public void run() {

		setColors(blue, black, white, yellow, green);
    strategy = new PassiveStrategy(this);

		while(true) {
			this.strategy.run();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		this.strategy.onScannedRobot();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		this.strategy.onHitByBullet();
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		this.strategy.onHitWall();
	}
  
  public void onHitRobot() {
	  this.strategy.onHitRobot();
  }
  
  public void setStrategy(RobottoStrategy strategy) {
	  this.strategy = strategy;
  }
  
  public RobottoStrategy getStrategy() {
	  return this.strategy;
  }
  
}