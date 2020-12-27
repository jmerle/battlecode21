// automatically generated by the FlatBuffers compiler, do not modify

package battlecode.schema;

/**
 * Actions that can be performed.
 * Purely aesthetic; have no actual effect on simulation.
 * (Although the simulation may want to track the 'parents' of
 * particular robots.)
 * Actions may have 'targets', which are the units on which
 * the actions were performed.
 */
public final class Action {
  private Action() { }
  /**
   * Politicians self-destruct and affect nearby bodies
   * Target: none
   */
  public static final byte EMPOWER = 0;
  /**
   * Muckrakers can expose a slanderer.
   * Target: an enemy body
   */
  public static final byte EXPOSE = 1;
  /**
   * Units can change their flag.
   * Target: new flag value
   */
  public static final byte SET_FLAG = 2;
  /**
   * Builds a unit (enlightent center).
   * Target: spawned unit
   */
  public static final byte SPAWN_UNIT = 3;
  /**
   * Places a bid (enlightent center).
   * Target: bid value
   */
  public static final byte PLACE_BID = 4;
  /**
   * A robot can change team after being empowered
   * Target: self
   */
  public static final byte CHANGE_TEAM = 5;
  /**
   * Dies due to an uncaught exception
   * Target: none
   */
  public static final byte DIE_EXCEPTION = 6;

  public static final String[] names = { "EMPOWER", "EXPOSE", "SET_FLAG", "SPAWN_UNIT", "PLACE_BID", "CHANGE_TEAM", "DIE_EXCEPTION", };

  public static String name(int e) { return names[e]; }
}

