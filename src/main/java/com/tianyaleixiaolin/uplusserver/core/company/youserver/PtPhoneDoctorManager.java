package com.tianyaleixiaolin.uplusserver.core.company.youserver;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author libolin wrote on 2018/11/20.
 */
@Service
public class PtPhoneDoctorManager {
    @Resource
    private PtPhoneDoctorRepository ptPhoneDoctorRepository;

    public PtPhoneDoctor find(Long id) {
        return ptPhoneDoctorRepository.getOne(id);
    }

    public PtPhoneDoctor add(PtPhoneDoctor ptPhoneDoctor) {
        return ptPhoneDoctorRepository.save(ptPhoneDoctor);
    }

    public PtPhoneDoctor update(PtPhoneDoctor ptPhoneDoctor) {
        return ptPhoneDoctorRepository.save(ptPhoneDoctor);
    }
}
