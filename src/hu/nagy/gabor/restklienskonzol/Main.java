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
            Film film = new Film(0, "Teszt", "kaland", 120, 7);
            filmHozzaadasa(url, film);
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

    public static void filmHozzaadasa(String url, Film film) throws IOException{
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(film.toJson());
        writer.flush();
        writer.close();
        os.close();

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
