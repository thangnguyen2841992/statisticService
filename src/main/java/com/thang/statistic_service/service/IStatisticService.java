package com.thang.statistic_service.service;

import com.thang.statistic_service.entity.Statistic;
import com.thang.statistic_service.model.StatisticDTO;
import com.thang.statistic_service.repository.IStatisticRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface IStatisticService {
    void addStatistic(StatisticDTO statisticDTO);
    List<StatisticDTO> getAllStatistic();
}

@Service
@Transactional
class StatisticServiceImpl implements IStatisticService {

    @Autowired
    private IStatisticRepository statisticRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addStatistic(StatisticDTO statisticDTO) {
        Statistic statistic = modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAllStatistic() {
        List<StatisticDTO> statisticDTOList = new ArrayList<>();
        statisticRepository.findAll().forEach(statisticDTO -> {
            statisticDTOList.add(modelMapper.map(statisticDTO, StatisticDTO.class));
        });
        return statisticDTOList;
    }
}
