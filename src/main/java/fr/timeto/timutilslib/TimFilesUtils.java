package fr.timeto.timutilslib;

import fr.theshark34.swinger.abstractcomponents.AbstractProgressBar;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TimFilesUtils {
    public static void unzip(String zipFilePath, String destDir) {
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());
                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void downloadFromInternet(String fileUrl, File dest) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        progressBar.setMaximum((int) maximumLong);
                        progressBar.setValue((int) progressLong);

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        progressBar.setMaximum((int) maximumLong);
                        progressBar.setValue((int) progressLong);

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, JTextComponent comp) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        comp.setText((int) result + "%");

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JTextComponent comp) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        progressBar.setMaximum((int) maximumLong);
                        progressBar.setValue((int) progressLong);
                        comp.setText((int) result + "%");

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JTextComponent comp) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        progressBar.setMaximum((int) maximumLong);
                        progressBar.setValue((int) progressLong);
                        comp.setText((int) result + "%");

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, JLabel comp) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        comp.setText((int) result + "%");

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, JProgressBar progressBar, JLabel comp) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        progressBar.setMaximum((int) maximumLong);
                        progressBar.setValue((int) progressLong);
                        comp.setText((int) result + "%");

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
    }

    public static void downloadFromInternet(String fileUrl, File dest, AbstractProgressBar progressBar, JLabel comp) throws IOException {
        Runnable updatethread = new Runnable() {
            public void run() {
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

                        // update progress bar
                        progressBar.setMaximum((int) maximumLong);
                        progressBar.setValue((int) progressLong);
                        comp.setText((int) result + "%");

                        bout.write(data, 0, x);
                    }
                    bout.close();
                    in.close();
                } catch (FileNotFoundException e) {
                    PopUpMessages.errorMessage("FileNotFoundException", e.getMessage());
                } catch (IOException e) {
                    PopUpMessages.errorMessage("IOException", e.getMessage());
                }
            }
        };
        new Thread(updatethread).start();
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
