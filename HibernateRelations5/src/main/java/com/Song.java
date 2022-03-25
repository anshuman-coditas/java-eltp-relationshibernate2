package com;

import javax.persistence.*;

@Entity
@Table(name = "audio")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    @Column(name = "song", columnDefinition = "LONGBLOB")
    private byte[] song;

    @ManyToOne
    @JoinColumn(name = "movie_id",referencedColumnName = "id")
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getSong() {
        return song;
    }

    public void setSong(byte[] song) {
        this.song = song;
    }
}
