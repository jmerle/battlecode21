/**
 * All of the top-level tunable options for the game client.
 */
export interface Config {
  /**
   * The version of the game we're simulating.
   */
  readonly gameVersion: string;

  /**
   * Whether to try to run the game in full-screen
   */
  readonly fullscreen: boolean;

  /**
   * Dimensions of the canvas
   */
  readonly width: number;
  readonly height: number;

  /**
   * Turns per second.
   *
   * (DISTINCT from fps!)
   */
  readonly defaultTPS: number;

  /**
   * The url to listen for websocket data on, if any.
   */
  readonly websocketURL: string | null;

  /**
   * The match file URL to load when we start.
   */
  readonly matchFileURL: string | null;

  /**
   * How often to poll the server via websocket, in ms.
   */
  readonly pollEvery: number;

  /**
   * Whether tournament mode is enabled.
   */
  readonly tournamentMode: boolean;

  /**
   * Whether or not to interpolate between frames.
   */
  interpolate: boolean;

  /**
   * Whether or not to draw a circle under each robot
   */
  circleBots: boolean; //TODO: is this needed?

  /**
   * Whether or not to display indicator dots and lines
   */
  indicators: boolean;

  /**
   * Whether or not to display the action radius.
   */
  seeActionRadius: boolean;

  /**
   * Whether or not to display the sensor radius.
   */
  seeSensorRadius: boolean;

  /**
   * Whether or not to display the detection radius.
   */
  seeDetectionRadius: boolean;

  /**
   * The mode of the game
   */
  mode: Mode;

  /**
   * Whether to display the splash screen.
   */
  splash: boolean;

  /**
   * Whether to display the grid
   */
  showGrid: boolean;

  /**
   * Viewoption for Swamp
   */
  viewSwamp: boolean;

  /**
   * Whether logs should show shorter header
   */
  shorterLogHeader: boolean;
}

/**
 * Different game modes that determine what is displayed on the client
 */
export enum Mode {
  GAME,
  HELP,
  LOGS,
  RUNNER,
  QUEUE,
  MAPEDITOR,
  PROFILER
}

/**
 * Handle setting up any values that the user doesn't set.
 */
export function defaults(supplied?: any): Config {
  let conf: Config = {
    gameVersion: "2020.2.0.3", //TODO: Change this on each release!
    fullscreen: false,
    width: 600,
    height: 600,
    defaultTPS: 20,
    websocketURL: null,
    matchFileURL: null,
    pollEvery: 500,
    tournamentMode: false,
    interpolate: true,
    circleBots: false,
    indicators: false,
    mode: Mode.QUEUE,
    splash: true,
    seeActionRadius: false,
    seeSensorRadius: false,
    seeDetectionRadius: false,
    showGrid: false,
    viewSwamp: true,
    shorterLogHeader: false,
  };
  return Object.assign(conf, supplied);
}
