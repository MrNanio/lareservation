package com.nankiewic.lareservation.Service;

import com.nankiewic.lareservation.Entity.Host;
import com.nankiewic.lareservation.Repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostService {

    HostRepository hostRepository;
    @Autowired
    public HostService(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    public Host save(Host host) {
        return hostRepository.save(host);
    }

    public Host findByUserFk(Long id) {
        return hostRepository.findByUserFk(id);
    }
}
