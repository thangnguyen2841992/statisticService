package com.thang.statistic_service.repository;

import com.thang.statistic_service.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatisticRepository extends JpaRepository<Statistic, Long> {
}
