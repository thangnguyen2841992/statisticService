package com.thang.statistic_service.controller;

import com.thang.statistic_service.entity.Statistic;
import com.thang.statistic_service.model.StatisticDTO;
import com.thang.statistic_service.service.IStatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticRestController {
    Logger logger = LoggerFactory.getLogger(StatisticRestController.class);

    @Autowired
    private IStatisticService statisticService;

    @PostMapping("/createNewStatistic.do")
    @PreAuthorize("hasAuthority('SCOPE_log')")
    public StatisticDTO createNewStatistic(@RequestBody StatisticDTO statisticDTO) {
        logger.info("StatisticController: Add statistic");

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        statisticService.addStatistic(statisticDTO);
        return statisticDTO;
    }
    @PreAuthorize("hasAuthority('SCOPE_read') && hasRole('ADMIN')")
    @GetMapping("/getAllStatistic.do")
    public List<StatisticDTO> getAllStatistic() {
        logger.debug("Get all statistic");
        return statisticService.getAllStatistic();
    }
}
