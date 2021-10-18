package ru.job4j.solid.srp;

import java.nio.file.Path;

public interface MusicBox {
    void play(Song song);
    void load(Path path, Song song);
    /* нарушающая принципа SRP:
    данный интерфейс иметь две цели, необходимо разделить эти действия на свои интерефейсы.
    */
}
