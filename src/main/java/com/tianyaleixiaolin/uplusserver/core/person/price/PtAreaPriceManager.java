package com.tianyaleixiaolin.uplusserver.core.person.price;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuwf
 */
@Service
public class PtAreaPriceManager {
    @Resource
    private PtAreaPriceRepository ptAreaPriceRepository;


    public PtAreaPrice findByAreaName(String areaName) {
        return ptAreaPriceRepository.findByAreaName(areaName);
    }


}
