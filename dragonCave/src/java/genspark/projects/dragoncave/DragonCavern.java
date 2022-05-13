package genspark.projects.dragoncave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.Random;

public class DragonCavern {

    public DragonCavern(int size) {
        this(size,new Random().nextInt(size));
    }
    public DragonCavern(int size, int goodCount)
    {
        int badCount = size - goodCount;
        if (size < 0) throw new RuntimeException("size cant be negative");
        caves = new ArrayList<>();
        for (int i = 0; i < goodCount; i++)
            caves.add(new DragonCave(true));
        for (int i=0; i < badCount; i++)
            caves.add(new DragonCave(false));
        Collections.shuffle(caves);
    }
    private List<DragonCave> caves;
    public Stream<DragonCave> stream() {
        return caves == null || caves.isEmpty() ? Stream.empty() : caves.stream();
    }
    public DragonCave nthCave(int n) {
        return caves.get(n);
    }
}
