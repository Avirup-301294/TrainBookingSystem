package com.avirup.booking.Repository.Train;

import com.avirup.booking.Model.Train;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository

public class TrainRepositoryImpl implements TrainRepository{
    private final List<Train> trainList = new ArrayList<>();
    private final Map<Integer, Train> trainMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(99);
    public TrainRepositoryImpl() {
        trainList.add(new Train(idCounter.incrementAndGet(),"A", "012"));
        trainList.add(new Train(idCounter.incrementAndGet(),"B", "121"));
        trainList.add(new Train(idCounter.incrementAndGet(),"B", "014"));

        for(Train train: trainList) {
            trainMap.put(Math.toIntExact(train.getId()), train);
        }
    }

    @Override
    public Train create(Train train) {
        long newId = idCounter.incrementAndGet();
        trainMap.put((int) newId, train);
        trainList.add(train);
        return train;
    }

    @Override
    public List<Train> findAll() {
        return trainList;
    }

    @Override
    public Train getTrain(Long id) {
        Train train = null;
        for(Map.Entry<Integer, Train> entry: trainMap.entrySet()) {
            if(entry.getValue().getId().equals(id)){
                train = entry.getValue();
                System.out.println(train);
                return train;
            }
        }
        return train;
    }

}
