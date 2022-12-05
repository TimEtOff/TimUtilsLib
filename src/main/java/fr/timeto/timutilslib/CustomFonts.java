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

    private static Font CustomFont(String path) {
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

    public static Font kollektifFont;
    public static Font kollektifBoldFont;
    public static Font kollektifBoldItalicFont;
    public static Font kollektifItalicFont;
    public static Font minecraftiaFont;
    private static final String FONT_PATH_KOLLEKTIF = "fonts/Kollektif.ttf";
    private static final String FONT_PATH_KOLLEKTIFBOLD = "fonts/Kollektif-Bold.ttf";
    private static final String FONT_PATH_KOLLEKTIFBOLDITALIC = "fonts/Kollektif-BoldItalic.ttf";
    private static final String FONT_PATH_KOLLEKTIFITALIC = "fonts/Kollektif-Italic.ttf";
    private static final String FONT_PATH_MINECRAFTIA = "fonts/Minecraftia-Regular.ttf";

    public static void initFonts() {
        kollektifFont = CustomFont(FONT_PATH_KOLLEKTIF);
        kollektifBoldFont = CustomFont(FONT_PATH_KOLLEKTIFBOLD);
        kollektifBoldItalicFont = CustomFont(FONT_PATH_KOLLEKTIFBOLDITALIC);
        kollektifItalicFont = CustomFont(FONT_PATH_KOLLEKTIFITALIC);
        minecraftiaFont = CustomFont(FONT_PATH_MINECRAFTIA);

    }
}
