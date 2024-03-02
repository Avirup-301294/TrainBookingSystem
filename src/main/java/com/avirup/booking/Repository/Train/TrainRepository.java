package com.avirup.booking.Repository.Train;

import com.avirup.booking.Model.Train;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrainRepository {
    List<Train> findAll();
    Train getTrain(Long id);
    Train create(Train train);
}
