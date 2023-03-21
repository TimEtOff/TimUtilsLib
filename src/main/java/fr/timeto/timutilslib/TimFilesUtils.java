package fr.timeto.timutilslib;

import fr.theshark34.swinger.abstractcomponents.AbstractProgressBar;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;
import java.util.Objects;

public class TimFilesUtils {
    private static Window selectedWindow = null;
    public static void setSelectedWindow(Window window) {
        selectedWindow = window;
    }

    public static Window getSelectedWindow() {return selectedWindow;}

    public static void downloadFromInternet(String fileUrl, File dest) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;

                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                progressBar.setMaximum((int) maximumLong);
                progressBar.setValue((int) progressLong);

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                progressBar.setMaximum((int) maximumLong);
                progressBar.setValue((int) progressLong);

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, JTextComponent percentText) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                percentText.setText((int) result + "%");

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JTextComponent percentText) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                progressBar.setMaximum((int) maximumLong);
                progressBar.setValue((int) progressLong);
                percentText.setText((int) result + "%");

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JTextComponent percentText) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                progressBar.setMaximum((int) maximumLong);
                progressBar.setValue((int) progressLong);
                percentText.setText((int) result + "%");

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, JLabel percentText) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                percentText.setText((int) result + "%");

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JLabel percentText) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                progressBar.setMaximum((int) maximumLong);
                progressBar.setValue((int) progressLong);
                percentText.setText((int) result + "%");

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JLabel percentText) throws IOException {
        try {

            URL url = new URL(fileUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();

            BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
            FileOutputStream fos = new FileOutputStream(dest);
            BufferedOutputStream bout = new BufferedOutputStream(
                    fos, 1024);
            byte[] data = new byte[1024];
            long downloadedFileSize = 0;
            int x = 0;
            while ((x = in.read(data, 0, 1024)) >= 0) {
                downloadedFileSize += x;

                // calculate progress
                long progressLong = downloadedFileSize;
                long maximumLong = completeFileSize;
                long result = (progressLong * 100) / maximumLong;
                if (selectedWindow != null) {
                    try {
                        Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                    } catch (Exception ex) {
                        try {
                            Taskbar.getTaskbar().setProgressValue((int) result);
                        } catch (UnsupportedOperationException ignored) {}
                    }
                } else {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }

                // update progress bar
                progressBar.setMaximum((int) maximumLong);
                progressBar.setValue((int) progressLong);
                percentText.setText((int) result + "%");

                bout.write(data, 0, x);
            }
            bout.close();
            in.close();

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue(102);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }

            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().requestUserAttention(true, false);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }

        } catch (FileNotFoundException e) {
            PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
        } catch (IOException e) {
            PopUpMessages.errorMessage("IOException", e.getMessage());
        }
    }

    public static String getBytesConverted(long bytes, boolean addUnit) {
        String unit = "B";
        if (Locale.getDefault().toString().contains("fr_")) {
            unit = "o";
        }
        if (-1000 < bytes && bytes < 1000) {
            if (addUnit) {
                return bytes + " " + unit;
            } else {
                return bytes + "";
            }
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        if (addUnit) {
            return String.format("%.1f %c" + unit, bytes / 1000.0, ci.current());
        } else {
            return String.format("%.1f", bytes / 1000.0, ci.current());
        }
    }

    public static void downloadFromInternet(String fileUrl, File dest, JTextComponent percentText, JTextComponent bytesText) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JTextComponent percentText, JTextComponent bytesText) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JTextComponent percentText, JTextComponent bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JLabel percentText, JTextComponent bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JLabel percentText, JTextComponent bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JLabel percentText, JTextComponent bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JTextComponent percentText, JLabel bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JTextComponent percentText, JLabel bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JTextComponent percentText, JLabel bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JLabel percentText, JLabel bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JLabel percentText, JLabel bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JLabel percentText, JLabel bytesText) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            progressBar.setMaximum((int) maximumLong);
            progressBar.setValue((int) progressLong);
            percentText.setText((int) result + "%");
            bytesText.setText(getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }

    public static void downloadFromInternetTest(String fileUrl, File dest) throws IOException {

        URL url = new URL(fileUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
        long completeFileSize = httpConnection.getContentLength();

        BufferedInputStream in = new BufferedInputStream(httpConnection.getInputStream());
        FileOutputStream fos = new FileOutputStream(dest);
        BufferedOutputStream bout = new BufferedOutputStream(
                fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
            downloadedFileSize += x;

            // calculate progress
            long progressLong = downloadedFileSize;
            long maximumLong = completeFileSize;
            long result = (progressLong * 100) / maximumLong;
            if (selectedWindow != null) {
                try {
                    Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, (int) result);
                } catch (Exception ex) {
                    try {
                        Taskbar.getTaskbar().setProgressValue((int) result);
                    } catch (UnsupportedOperationException ignored) {}
                }
            } else {
                try {
                    Taskbar.getTaskbar().setProgressValue((int) result);
                } catch (UnsupportedOperationException ignored) {}
            }

            // update progress bar
            System.out.println("Percent: " + (int) result + "%");
            System.out.println("Bytes: " + getBytesConverted(progressLong, true) + "/" + getBytesConverted(maximumLong, true));

            bout.write(data, 0, x);
        }
        bout.close();
        in.close();

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().setWindowProgressValue(selectedWindow, 102);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().setProgressValue(102);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().setProgressValue(102);
            } catch (UnsupportedOperationException ignored) {}
        }

        if (selectedWindow != null) {
            try {
                Taskbar.getTaskbar().requestWindowUserAttention(selectedWindow);
            } catch (Exception ex) {
                try {
                    Taskbar.getTaskbar().requestUserAttention(true, false);
                } catch (UnsupportedOperationException ignored) {}
            }
        } else {
            try {
                Taskbar.getTaskbar().requestUserAttention(true, false);
            } catch (UnsupportedOperationException ignored) {}
        }

    }



    public static void deleteDirectory(File directory, boolean callback) throws NullPointerException {
        for (File file: Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                deleteDirectory(file, callback);
                if (callback) System.out.println("Deleted '" + file + "' directory");
            } else {
                file.delete();
                if (callback) System.out.println("Deleted '" + file + "' file");
            }
        }
    }

    public static void copyFile(File src, File dest, boolean callback) throws IOException {
        // Créer l'objet File Reader
        FileReader fr = new FileReader(src);
        // Créer l'objet BufferedReader
        BufferedReader br = new BufferedReader(fr);
        // Créer l'objet File Writer
        FileWriter fw = new FileWriter(dest);
        String str;
        // Copie le contenu dans le nouveau fichier
        while((str = br.readLine()) != null)
        {
            fw.write(str);
            fw.write(System.lineSeparator());
            fw.flush();
        }
        fw.close();
        if (callback) System.out.println("File "+ src + "  > " + dest);
    }

    public static void copyFiles(File src, File dest, boolean callback) throws IOException {
        if(src.isDirectory()){
            //si le répertoire n'existe pas, créez-le
            if(!dest.exists()){
                dest.mkdir();
                if (callback) System.out.println("Folder "+ src + "  > " + dest);
            }
            //lister le contenu du répertoire
            String[] files = src.list();

            for (String f : files) {
                //construire la structure des fichiers src et dest
                File srcF = new File(src, f);
                File destF = new File(dest, f);
                //copie récursive
                copyFiles(srcF, destF, callback);
            }
        }else{
            //si src est un fichier, copiez-le.
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;
            //copier le contenu du fichier
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            if (callback) System.out.println("File " + src + " > " + dest);
        }

    }
}
