package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Song song=new Song();
        InputStream inputStream = song.getClass().getClassLoader().getResourceAsStream("song1.mp3");
        song.setSong(IOUtils.toByteArray(inputStream));

        Song song1=new Song();
        InputStream inputStream1 = song.getClass().getClassLoader().getResourceAsStream("song2.mp3");
        song1.setSong(IOUtils.toByteArray(inputStream1));

        Movie movie=new Movie();
        movie.setId(1);
        movie.setName("Peaky Blinders");

        ArrayList<Song> songs=new ArrayList<>();
        songs.add(song);
        songs.add(song1);
        movie.setSongs(songs);

        session.save(movie);
        transaction.commit();
    }
}
