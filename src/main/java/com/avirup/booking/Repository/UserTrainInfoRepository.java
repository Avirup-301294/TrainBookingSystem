package com.avirup.booking.Repository;

import com.avirup.booking.Model.UserTrainInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTrainInfoRepository extends JpaRepository<UserTrainInfo, Long> {
}
