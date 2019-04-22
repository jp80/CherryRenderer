package com.chrrubin.cherryrenderer;

import com.chrrubin.cherryrenderer.gui.AbstractStage;
import com.chrrubin.cherryrenderer.gui.PlayerStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CherryRenderer extends Application {
    private Logger LOGGER = Logger.getLogger(CherryRenderer.class.getName());

    @Override
    public void start(Stage primaryStage){
        String agent = "CherryRenderer/" + CherryPrefs.VERSION + " (" + System.getProperty("os.name") + "; " + System.getProperty("os.arch") + "; " + System.getProperty("os.version") + ")";
        System.setProperty("http.agent", agent);
        try {
            String propertiesFileName;
            switch (CherryPrefs.LogLevel.LOADED_VALUE) {
                case "DEBUG":
                    propertiesFileName = "log-debug.properties";
                    break;
                case "DEBUG+":
                    propertiesFileName = "log-debugplus.properties";
                    break;
                case "ALL":
                    propertiesFileName = "log-all.properties";
                    break;
                default:
                    propertiesFileName = "log-info.properties";
                    break;
            }
            InputStream inputStream = CherryRenderer.class.getClassLoader().getResourceAsStream(propertiesFileName);
            LogManager.getLogManager().readConfiguration(inputStream);
            LOGGER.fine("Loaded logger properties from " + propertiesFileName);

            if(!CherryPrefs.HardwareAcceleration.LOADED_VALUE){
                LOGGER.fine("Using software acceleration.");
                System.setProperty("prism.order", "sw");
            }

            AbstractStage stage = new PlayerStage();
            stage.prepareStage();
            stage.show();
        }
        catch (IOException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
