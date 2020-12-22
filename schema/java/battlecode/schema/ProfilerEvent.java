// automatically generated by the FlatBuffers compiler, do not modify

package battlecode.schema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * These tables are set-up so that they match closely with speedscope's file format documented at
 * https://github.com/jlfwong/speedscope/wiki/Importing-from-custom-sources.
 * The client uses speedscope to show the recorded data in an interactive interface.
 * A single event in a profile. Represents either an open event (meaning a
 * method has been entered) or a close event (meaning the method was exited).
 */
public final class ProfilerEvent extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_12_0(); }
  public static ProfilerEvent getRootAsProfilerEvent(ByteBuffer _bb) { return getRootAsProfilerEvent(_bb, new ProfilerEvent()); }
  public static ProfilerEvent getRootAsProfilerEvent(ByteBuffer _bb, ProfilerEvent obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public ProfilerEvent __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * Whether this is an open event (true) or a close event (false).
   */
  public boolean isOpen() { int o = __offset(4); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  /**
   * The bytecode counter at the time the event occurred.
   */
  public int at() { int o = __offset(6); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  /**
   * The index of the method name in the ProfilerFile.frames array.
   */
  public int frame() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createProfilerEvent(FlatBufferBuilder builder,
      boolean isOpen,
      int at,
      int frame) {
    builder.startTable(3);
    ProfilerEvent.addFrame(builder, frame);
    ProfilerEvent.addAt(builder, at);
    ProfilerEvent.addIsOpen(builder, isOpen);
    return ProfilerEvent.endProfilerEvent(builder);
  }

  public static void startProfilerEvent(FlatBufferBuilder builder) { builder.startTable(3); }
  public static void addIsOpen(FlatBufferBuilder builder, boolean isOpen) { builder.addBoolean(0, isOpen, false); }
  public static void addAt(FlatBufferBuilder builder, int at) { builder.addInt(1, at, 0); }
  public static void addFrame(FlatBufferBuilder builder, int frame) { builder.addInt(2, frame, 0); }
  public static int endProfilerEvent(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public ProfilerEvent get(int j) { return get(new ProfilerEvent(), j); }
    public ProfilerEvent get(ProfilerEvent obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

