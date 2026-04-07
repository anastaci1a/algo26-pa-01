/**
 * Provides core utilities to extend {@code javafx} functionality, general io/cli, and that of other related tools.
 *
 * <p>The packages contained within {@code ana.*} ("ana dot star") aim to abstract away repeatable operations for:
 * graphical applications which use {@code javafx}, frame-by-frame user input, cli menus, color operations, and others.</p>
 *
 * <h2>Package Map</h2>
 * <ul>
 // *   <li>{// @link ana.fx} – Utilities and extended functionality for {@code javafx}</li>
 *   <li>{@link assignment.ana.io} – Utilities for modular cli, user input devices, and file operations</li>
 *   <li>{@link assignment.ana.lang} – Core exceptions for all local packages</li>
 *   <li>{@link assignment.ana.util} – Utilities for colors, math/vectors, and text formatting</li>
 * </ul>
 *
 * @since 1.0
 * @author anastaci1a
 */
module ana {
    // req (removed)

    // requires javafx.graphics;

    // exp lib

    // exports ana.fx.app;
    // exports ana.fx.canvas;
    // exports ana.fx.canvas.draw;
    // exports ana.fx.app.launcher;
    // exports ana.fx.window;

    exports assignment.ana.io.cli;
    // exports ana.io.device;
    // exports ana.io.device.impl;
    // exports ana.io.device.keyboard;
    // exports ana.io.device.mouse;
    // exports ana.io.file;

    exports assignment.ana.lang;
    // exports ana.lang.fx;

    exports assignment.ana.util.color;
    exports assignment.ana.util.math;
    exports assignment.ana.util.math.vector.bounds;
    exports assignment.ana.util.math.vector.point;
    exports assignment.ana.util.math.vector;
    exports assignment.ana.util.text;
    exports assignment.ana.util.theme;

    // exp assignment

    exports assignment.heaps;
}