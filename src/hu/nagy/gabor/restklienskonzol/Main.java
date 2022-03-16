package hu.nagy.gabor.restklienskonzol;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        String url = "https://retoolapi.dev/Q304E6/film";
        try {
            osszesFilmkiirasa(url);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void osszesFilmkiirasa(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setRequestProperty("Accept", "text/json");
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String sor = br.readLine();
        while (sor != null){
            System.out.println(sor);
            sor = br.readLine();
        }
        br.close();
        is.close();
    }

    public static void filmHozzaadasa(String url) throws IOException{
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));

        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String sor = br.readLine();
        while (sor != null){
            System.out.println(sor);
            sor = br.readLine();
        }
        br.close();
        is.close();
    }
}
