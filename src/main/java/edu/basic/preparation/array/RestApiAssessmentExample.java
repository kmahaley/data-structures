package edu.basic.preparation.array;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RestApiAssessmentExample {

    /**
     * Get movie titles sorted by year and then titles alphabetically.
     * select only those titles with poster "N/A"
     *
     * get movies from http get call and populate. use google gson library to map.
     *
     * @param substr
     * @return
     */
    static String[] getMovieTitles(String substr) {

        if (substr == null || substr.length() == 0) {
            return new String[0];
        }
        final List<Movie> movieList = new ArrayList<>();
        int start = 0, end = 0;
        do {
            start++;
            final PageResponse pageResponse = getData(substr, start);
            end = pageResponse.total_pages;
            if(pageResponse.data.size() > 0) {
                movieList.addAll(pageResponse.data);
            } else {
                break;
            }

        } while (start != end);

        final Iterator<Movie> iterator = movieList.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();

            if (movie.Poster.equals("N/A")){
                iterator.remove();
            }
        }

        movieList.sort(new MovieComparator());
        //Collections.sort(movieList, new MovieComparator());
        List<String> titles = new LinkedList<>();
        movieList.forEach(m -> titles.add(m.Title));
        final String[] toArray = titles.toArray(new String[titles.size()]);
        return toArray;
    }

    /**
     * Code to read from restful json call
     */
    public static PageResponse getData(String subStr, int page) {
        PageResponse pageResponse = new PageResponse();
        HttpURLConnection connection = null;
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+subStr+"&page="+page;

        try {
            URL getUrl = new URL(url);
            connection = (HttpURLConnection) getUrl.openConnection();
            connection.setRequestMethod("GET");
            StringBuilder content;

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                }
            }
            final String response = content.toString();
            Gson gson = new Gson();
            return gson.fromJson(response, PageResponse.class);

        } catch (MalformedURLException ex) {
            System.out.println("Url if incorrect "+url);
        } catch (IOException ex) {
            System.out.println("Enable to read the response from get call");
        } finally {
            connection.disconnect();
        }
        return pageResponse;
    }

    public static class PageResponse {
        int page;
        int per_page;
        int total;
        int total_pages;
        List<Movie> data;

        public PageResponse() {
        }

    }

    public static class Movie {
        String Title;
        String Poster;
        String Type;
        int Year;
        String imdbID;
    }

    public static class MovieComparator implements Comparator<Movie> {

        @Override
        public int compare(Movie m1, Movie m2) {

            int yearCompare = m1.Year - m2.Year;
            if (yearCompare != 0) {
                return yearCompare;
            } else {
                return m1.Title.compareTo(m2.Title);
            }
        }
    }
}
