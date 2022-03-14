package hu.nagy.gabor.restklienskonzol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        String url = "";
        try {
            osszesFilmkiirasa(url);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void osszesFilmkiirasa(String url) throws IOException {
        URL urlObject = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObject.openConnection();
        conn.setRequestProperty("Accept", "text/csv");
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
