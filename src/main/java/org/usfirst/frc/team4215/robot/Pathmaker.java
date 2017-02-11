package main.java.org.usfirst.frc.team4215.robot;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.modifiers.TankModifier;


/**
 * This class defines each autonomous path and configures it.
 * IMPORTANT: Make sure that when autonomous is initialized both configuration and trajectory are set to null, or else the config and trajectory will not be initialized!
 * 
 * @author Jack Rausch
 *
 */
public class Pathmaker {
	
	private double dt;
	private double MAX_VELOCITY;
	private double MAX_ACCELERATION;
	private double MAX_JERK;
	private Waypoint[] auto;
	private Trajectory.Config configuration;
	private Trajectory trajectory;
	private TankModifier modifier;
	
	
	/**
	 * This method must be used at the beginning of Autonomous for the Pathmaker code to work.
	 * @author Jack Rausch
	 */
	public void pathmInit(){
		Trajectory.Config configuration = null;
		Trajectory trajectory = null;
		TankModifier modifier = null;
	}
	
	/**
	 * This method creates the configuration based on certain parameters. 
	 * If you wish to get the configuration use the getConfig method instead.
	 * @author Jack Rausch
	 * @param dt
	 * @param MAX_VELOCITY
	 * @param MAX_ACCELERATION
	 * @param MAX_JERK
	 * @return config(Don't use)
	 */
	public Trajectory.Config config(double dt, double MAX_VELOCITY, double MAX_ACCELERATION, double MAX_JERK){
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
        		Trajectory.Config.SAMPLES_HIGH, dt, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
        return config;

	}
	
	Waypoint[] auto1 = new Waypoint[]{
			//Put points here
	};
	
	Waypoint[] auto2 = new Waypoint[]{
			//Put points here
	};
	
	Waypoint[] auto3 = new Waypoint[]{
			//Put points here
	};
	
	/**
	 * This method gets the trajectory if it has already been generated or generates it if necessary.
	 * @author Jack Rausch
	 * @param auto
	 * @param config
	 * @return trajectory
	 */
	public Trajectory getTrajectory(Waypoint[] auto, Trajectory.Config config){
		if (trajectory == null){
			trajectory = Pathfinder.generate(auto, config);
			return trajectory;
		} else {
			return trajectory;
		}
	}
	
	/**
	 * This method gets the configuration if it has already been generated or generates it if necessary. Use this method to get the configuration.
	 * @author Jack Rausch
	 * @param dt
	 * @param MAX_VELOCITY
	 * @param MAX_ACCELERATION
	 * @param MAX_JERK
	 * @return configuration
	 */
	public Trajectory.Config getConfig(double dt, double MAX_VELOCITY, double MAX_ACCELERATION, double MAX_JERK){
		if (configuration == null){
			//Admittedly a very inefficient way to do this, but I'll fix it later(never).
			configuration = config(dt, MAX_VELOCITY, MAX_ACCELERATION, MAX_JERK);
			return configuration;
		} else {
			return configuration;
		}
				
	}

	/**
	 * This method creates a modified trajectory based on wheel base width, or merely gets it if you have already created said trajectory.
	 * @author Jack Rausch
	 * @param wheelbasewidth
	 * @param trajectory
	 * @return modifier
	 */
	public TankModifier getModifier(double wheelbasewidth, Trajectory trajectory){
		if (modifier == null) {
			TankModifier mod = new TankModifier(trajectory).modify(wheelbasewidth);
			modifier = mod.modify(wheelbasewidth);
			return modifier;
		} else 
			return modifier;
		
	}
	
	/**
	 * This method gets the left trajectory
	 * @author Jack Rausch
	 * @param modifier
	 * @return leftTraj
	 */
	public Trajectory getLeftTrajectory(TankModifier modifier){
		Trajectory leftTraj = modifier.getLeftTrajectory();
		return leftTraj;
	}
	
	/**
	 * This method gets the right trajectory
	 * @param modifier
	 * @return rightTraj
	 */
	public Trajectory getRightTrajectory(TankModifier modifier){
		Trajectory rightTraj = modifier.getRightTrajectory();
		return rightTraj;
	}
	
	
	
	
	
	//Simple getters and setters
	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}

	public double getMAX_VELOCITY() {
		return MAX_VELOCITY;
	}

	public void setMAX_VELOCITY(double mAX_VELOCITY) {
		MAX_VELOCITY = mAX_VELOCITY;
	}

	public double getMAX_ACCELERATION() {
		return MAX_ACCELERATION;
	}

	public void setMAX_ACCELERATION(double mAX_ACCELERATION) {
		MAX_ACCELERATION = mAX_ACCELERATION;
	}

	public double getMAX_JERK() {
		return MAX_JERK;
	}

	public void setMAX_JERK(double mAX_JERK) {
		MAX_JERK = mAX_JERK;
	}

	public Waypoint[] getAuto1() {
		return auto1;
	}

	public void setAuto1(Waypoint[] auto1) {
		this.auto1 = auto1;
	}

	public Waypoint[] getAuto2() {
		return auto2;
	}

	public void setAuto2(Waypoint[] auto2) {
		this.auto2 = auto2;
	}

	public Waypoint[] getAuto3() {
		return auto3;
	}

	public void setAuto3(Waypoint[] auto3) {
		this.auto3 = auto3;
	}

}
