package com.chrrubin.cherryrenderer;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class CherryLogFileHandler extends FileHandler {

    public CherryLogFileHandler() throws IOException {
        super("%h/CherryRenderer.%g.log", 1024 * 1024, 3);
        setFormatter(new org.seamless.util.logging.SystemOutLoggingHandler.SimpleFormatter());
        setLevel(Level.ALL);
    }
}
