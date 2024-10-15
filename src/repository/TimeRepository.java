package repository;

import model.Time;
import utils.LeitorCsv;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TimeRepository {
    private List<Time> times;

    public TimeRepository(String filePath) throws IOException {
        this.times = LeitorCsv.readCsv(filePath).stream()
                .map(data -> new Time(data[0], data[1]))
                .collect(Collectors.toList());
    }

    public List<Time> getTimes(){
        return times;
    }
}
