package com.avirup.booking.Service.Train;


import com.avirup.booking.Model.Train;
import com.avirup.booking.Repository.Train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrainServiceImpl implements TrainService{
    @Autowired
    private TrainRepository trainRepository;

    @Override
    public Train getTrain(Long id) {
        return trainRepository.getTrain(id);
    }

    @Override
    public Train create(Train train) {
        return trainRepository.create(train);
    }
}
