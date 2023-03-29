package fr.timeto.timutilslib;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class CustomFonts {
    private static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = CustomFonts.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public static Font customFont(String path) {
        Font customFont = loadFont(path, 24f);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);
        return customFont;

    }
    private static Font loadFont(String path, float size){
        try {
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, getFileFromResourceAsStream(path));
            return myFont.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static Font kollektifFont = customFont("fonts/Kollektif.ttf");
    public static Font kollektifBoldFont = customFont("fonts/Kollektif-Bold.ttf");
    public static Font kollektifBoldItalicFont = customFont("fonts/Kollektif-BoldItalic.ttf");
    public static Font kollektifItalicFont = customFont("fonts/Kollektif-Italic.ttf");
    public static Font minecraftiaFont = customFont("fonts/Minecraftia-Regular.ttf");

    public static Font robotoThinFont = customFont("fonts/Roboto-Thin.ttf");
    public static Font robotoThinItalicFont = customFont("fonts/Roboto-ThinItalic.ttf");
    public static Font robotoRegularFont = customFont("fonts/Roboto-Regular.ttf");
    public static Font robotoItalicFont = customFont("fonts/Roboto-Italic.ttf");
    public static Font robotoLightFont = customFont("fonts/Roboto-Light.ttf");
    public static Font robotoLightItalicFont = customFont("fonts/Roboto-LightItalic.ttf");
    public static Font robotoMediumFont = customFont("fonts/Roboto-Medium.ttf");
    public static Font robotoMediumItalicFont = customFont("fonts/Roboto-MediumItalic.ttf");
    public static Font robotoBoldFont = customFont("fonts/Roboto-Bold.ttf");
    public static Font robotoBoldItalicFont = customFont("fonts/Roboto-BoldItalic.ttf");
    public static Font robotoBlackFont = customFont("fonts/Roboto-Black.ttf");
    public static Font robotoBlackItalicFont = customFont("fonts/Roboto-BlackItalic.ttf");
}
