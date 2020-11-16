package battlecode.common;
import java.util.ArrayList;

/**
 * A RobotController allows contestants to make their robot sense and interact
 * with the game world. When a contestant's <code>RobotPlayer</code> is
 * constructed, it is passed an instance of <code>RobotController</code> that
 * controls the newly created robot.
 */
@SuppressWarnings("unused")
public strictfp interface RobotController {

    // *********************************
    // ****** GLOBAL QUERY METHODS *****
    // *********************************

    /**
     * Returns the current round number, where round 1 is the first round of the
     * match.
     *
     * @return the current round number, where round 1 is the first round of the
     * match.
     *
     * @battlecode.doc.costlymethod
     */
    int getRoundNum();

    /**
     * Returns the team's total votes.
     *
     * @return the team's total votes.
     *
     * @battlecode.doc.costlymethod
     */
    int getTeamVotes();

    /**
     * Returns the number of robots on your team, including Centers of Enlightenment.
     * If this number ever reaches zero, and you have less votes than your opponent,
     * you lose by default (because you can't get any more votes with no Centers of Enlightenment).
     *
     * @return the number of robots on your team
     *
     * @battlecode.doc.costlymethod
     */
    int getRobotCount();

    /**
     * Returns the width of the map.
     *
     * @return the width of the map.
     *
     * @battlecode.doc.costlymethod
     */
    int getMapWidth();

    /**
     * Returns the height of the map.
     *
     * @return the height of the map.
     *
     * @battlecode.doc.costlymethod
     */
    int getMapHeight();

    // *********************************
    // ****** UNIT QUERY METHODS *******
    // *********************************

    /**
     * Returns the ID of this robot.
     *
     * @return the ID of this robot.
     *
     * @battlecode.doc.costlymethod
     */
    int getID();

    /**
     * Returns this robot's Team.
     *
     * @return this robot's Team.
     *
     * @battlecode.doc.costlymethod
     */
    Team getTeam();

    /**
     * Returns this robot's type (CENTER, MUCKRAKER, POLITICIAN, etc.).
     *
     * @return this robot's type.
     *
     * @battlecode.doc.costlymethod
     */
    RobotType getType();

    /**
     * Returns this robot's current location.
     *
     * @return this robot's current location.
     *
     * @battlecode.doc.costlymethod
     */
    MapLocation getLocation();

    /**
     * Returns the robot's current sensor radius squared, which is affected
     * by the current pollution level at the present location.
     *
     * @return an int, the current sensor radius squared
     *
     * @battlecode.doc.costlymethod
     */
     int getSensorRadiusSquared();


    // ***********************************
    // ****** GENERAL SENSOR METHODS *****
    // ***********************************

    /**
     * Senses whether a MapLocation is on the map. Will throw an exception if
     * the location is not within the sensor range.
     *
     * @param loc the location to check
     * @return true if the location is on the map; false otherwise.
     * @throws GameActionException if the location is not within sensor range.
     *
     * @battlecode.doc.costlymethod
     */
    boolean onTheMap(MapLocation loc) throws GameActionException;

    /**
     * Senses whether the given location is within the robot's sensor range, and if it is on the map.
     *
     * @param loc the location to check
     * @return true if the given location is within the robot's sensor range and is on the map; false otherwise.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canSenseLocation(MapLocation loc);

    /**
     * Senses whether a point at the given radius squared is within the robot's sensor range.
     *
     * @param radiusSquared the radius to check
     * @return true if the given radius is within the robot's sensor range; false otherwise.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canSenseRadiusSquared(int radiusSquared);

    /**
     * Senses whether there is a robot at the given location.
     *
     * @param loc the location to check
     * @return true if there is a robot at the given location; false otherwise.
     * @throws GameActionException if the location is not within sensor range.
     *
     * @battlecode.doc.costlymethod
     */
    boolean isLocationOccupied(MapLocation loc) throws GameActionException;

    /**
     * Senses the robot at the given location, or null if there is no robot
     * there.
     *
     * @param loc the location to check
     * @return the robot at the given location.
     * @throws GameActionException if the location is not within sensor range.
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo senseRobotAtLocation(MapLocation loc) throws GameActionException;

    /**
     * Tests whether the given robot exists and if it is
     * within this robot's sensor range.
     *
     * @param id the ID of the robot to query
     * @return true if the given robot is within this robot's sensor range; false otherwise.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canSenseRobot(int id);

    /**
     * Senses information about a particular robot given its ID.
     *
     * @param id the ID of the robot to query
     * @return a RobotInfo object for the sensed robot.
     * @throws GameActionException if the robot cannot be sensed (for example,
     * if it doesn't exist or is out of sensor range).
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo senseRobot(int id) throws GameActionException;

    /**
     * Returns all robots within sense radius. The objects are returned in no
     * particular order.
     *
     * @return array of RobotInfo objects, which contain information about all
     * the robots you sensed.
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots();

    /**
     * Returns all robots that can be sensed within a certain distance of this
     * robot. The objects are returned in no particular order.
     *
     * @param radiusSquared return robots this distance away from the center of
     * this robot. If -1 is passed, all robots within sense radius are returned.
     * @return array of RobotInfo objects of all the robots you sensed.
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots(int radiusSquared);

    /**
     * Returns all robots of a given team that can be sensed within a certain
     * distance of this robot. The objects are returned in no particular order.
     *
     * @param radiusSquared return robots this distance away from the center of
     * this robot. If -1 is passed, all robots within sense radius are returned
     * @param team filter game objects by the given team. If null is passed,
     * robots from any team are returned
     * @return array of RobotInfo objects of all the robots you sensed.
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots(int radiusSquared, Team team);

    /**
     * Returns all robots of a given team that can be sensed within a certain
     * radius of a specified location. The objects are returned in order of
     * increasing distance from the specified center.
     *
     * @param center center of the given search radius
     * @param radius return robots this distance away from the given center
     * location. If -1 is passed, all robots within sense radius are returned
     * @param team filter game objects by the given team. If null is passed,
     * objects from all teams are returned
     * @return sorted array of RobotInfo objects of the robots you sensed.
     *
     * @battlecode.doc.costlymethod
     */
    RobotInfo[] senseNearbyRobots(MapLocation center, int radius, Team team);

    /**
     * Given a location, returns if that location is covered by Martian swamp.
     *
     * @param loc the given location
     * @return whether or not the location is passable as a result of being covered by swamp.
     *
     * @throws GameActionException if the robot cannot sense the given location
     *
     * @battlecode.doc.costlymethod
     */
    boolean senseSwamping(MapLocation loc) throws GameActionException;
  
    /**
     * Returns the location adjacent to current location in the given direction.
     *
     * @param dir the given direction
     * @return the location adjacent to current location in the given direction.
     *
     * @battlecode.doc.costlymethod
     */
    MapLocation adjacentLocation(Direction dir);

    // ***********************************
    // ****** READINESS METHODS **********
    // ***********************************
    
    /**
     * Tests whether the robot can perform an action. Returns
     * <code>getCooldownTurns() &lt; 1</code>.
     * 
     * @return true if the robot can perform an action.
     *
     * @battlecode.doc.costlymethod
     */
    boolean isReady();

    /**
     * Returns the number of cooldown turns remaining before this unit can act again.
     * When this number is strictly less than 1, isReady() is true and the robot
     * can perform actions again.
     *
     * @return the number of cooldown turns remaining before this unit can act again.
     *
     * @battlecode.doc.costlymethod
     */
    float getCooldownTurns();

    // ***********************************
    // ****** MOVEMENT METHODS ***********
    // ***********************************

    /**
     * Tells whether this robot can move one step in the given direction.
     * Returns false if the robot is a building, if the target location
     * is not on the map, if the target location is occupied, and if the robot is not ready
     * based on the cooldown. Does not check if the location is covered with swamp;
     * bots may choose to enter the swamp.
     *
     * If a bot enters the swamp then they gain cooldown turns, or 
     * they won't be able to do actions for longer.
     *
     * @param dir the direction to move in
     * @return true if it is possible to call <code>move</code> without an exception
     *
     * @battlecode.doc.costlymethod
     */
    boolean canMove(Direction dir);
    
    /**
     * Moves one step in the given direction.
     *
     * @param dir the direction to move in
     * @throws GameActionException if the robot cannot move one step in this
     * direction, such as cooldown being &gt;= 1, the target location being
     * off the map, or the target destination being occupied with either
     * another robot.
     *
     * @battlecode.doc.costlymethod
     */
    void move(Direction dir) throws GameActionException;

    // ***********************************
    // ****** BUILDING/SPAWNING **********
    // ***********************************

    /**
     * Tests whether the robot can build a robot of the given type in the
     * given direction. Checks that the robot is of a type that can build bots, 
     * that the robot can build the desired type, that the target location is on the map,
     * that the target location is not occupied, that the target location
     * is not covered in swamp, that the robot has the amount of influence it's trying to spend,
     * and that there are cooldown turns remaining.
     *
     * @param dir the direction to build in
     * @param type the type of robot to build
     * @return whether it is possible to build a robot of the given type in the
     * given direction.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canBuildRobot(int influence, RobotType type, Direction dir);

    /**
     * Builds a robot of the given type in the given direction.
     *
     * @param dir the direction to spawn the unit
     * @param type the type of robot to build
     * @throws GameActionException if the conditions of <code>canBuildRobot</code>
     * are not all satisfied.
     *
     * @battlecode.doc.costlymethod
     */
    void buildRobot(int influence, RobotType type, Direction dir) throws GameActionException;

    // ***********************************
    // ****** POLITICIAN METHODS ********* 
    // ***********************************

    /**
     * Tests whether the robot can empower.
     * Checks that the robot is a politician, and if there are cooldown
     * turns remaining.
     * 
     * @return whether it is possible to empower on that round.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canEmpower();

    /**
     * Runs the "empower" ability of a politician:
     * Divides all of its conviction evenly among any units within
     * squared distance < 4. For each friendly unit, increase its conviction
     * by that amount. For each unfriendly unit, decrease its conviction
     * by that amount, and, if its conviction becomes negative, it will become
     * a newly-instantiated unit of the same type but the opposite team.
     *
     * This also causes the politician unit to self-destruct; 
     * on the next round it will no longer be in the world. 
     *
     * @throws GameActionException if conditions for empowering are not all satisfied
     * @battlecode.doc.costlymethod
     */
    void empower() throws GameActionException;


    // ***********************************
    // ****** MUCKRAKER METHODS ********** 
    // ***********************************

    /**
     * Tests whether the robot can expose at a given location.
     * Checks that the robot is a muckraker, that the robot is within
     * sensor radius of the muckraker, and if there are cooldown
     * turns remaining.
     * 
     * Does not check if a slanderer is on the location given.
     * @return whether it is possible to expose on that round at that location.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canExpose(MapLocation  loc);

    /** 
     * Given a location, exposes a slanderer on that location, if a slanderer exists on that location.
     * If a slanderer is exposed then on the next round it will no longer be in the world.
     * Aside from this, a successful expose temporarily increases the total conviction 
     * of all Politicians on the same team by a factor 1.01^(influence) for the next XX turns
     *
     * If the conditions for exposing are all met but loc does not contain a slanderer,
     * no Exception is thrown, but the bytecode and cooldown costs are still consumed. 
     * @throws GameActionException if conditions for exposing are not all satisfied 
     * @battlecode.doc.costlymethod
     */
    void expose(MapLocation loc) throws GameActionException;

    /**
     * Tests whether the robot can detect, which is a weaker form of sensing with a larger range.
     * When you detect you only get the list of occupied MapLocations within a large range, but not
     * the RobotInfo for the bots on each location occupied.
     * Checks that the robot is a muckraker, and if there are cooldown
     * turns remaining.
     *  
     * @return whether it is possible to detect on that round at that location.
     *
     * @battlecode.doc.costlymethod
     */
    boolean canExpose(MapLocation  loc);

    /** 
     * Returns the map locations of all locations within detection radius,
     * that contain a bot, without specifying the bots that are on each location.
     * @throws GameActionException if conditions for detecting are not satisfied
     * @battlecode.doc.costlymethod
     */
    MapLocation[] detect() throws GameActionException;
 
    // ***********************************
    // ****** OTHER ACTION METHODS *******
    // ***********************************

    /**
     * Causes your team to lose the game. It's like typing "gg."
     *
     * @battlecode.doc.costlymethod
     */
    void resign();

    // ***********************************
    // ******** DEBUG METHODS ************
    // ***********************************

    /**
     * Draw a dot on the game map for debugging purposes.
     *
     * @param loc the location to draw the dot.
     * @param red the red component of the dot's color.
     * @param green the green component of the dot's color.
     * @param blue the blue component of the dot's color.
     *
     * @battlecode.doc.costlymethod
     */
    void setIndicatorDot(MapLocation loc, int red, int green, int blue);

    /**
     * Draw a line on the game map for debugging purposes.
     *
     * @param startLoc the location to draw the line from.
     * @param endLoc the location to draw the line to.
     * @param red the red component of the line's color.
     * @param green the green component of the line's color.
     * @param blue the blue component of the line's color.
     *
     * @battlecode.doc.costlymethod
     */
    void setIndicatorLine(MapLocation startLoc, MapLocation endLoc, int red, int green, int blue);
}
