package com.alexbusf.apicrudalexbusf.services;

import com.alexbusf.apicrudalexbusf.models.Thing;
import com.alexbusf.apicrudalexbusf.repositories.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThingService implements IThingService{
    @Autowired
    private ThingRepository thingRepository;

    @Override
    public List<Thing> getAll() {
        return thingRepository.findAll();
    }

    @Override
    public Thing getById(Long id) {
        return thingRepository.findById(id).get();
    }

    @Override
    public Thing save(Thing thing) {
        return thingRepository.save(thing);
    }

    @Override
    public void delete(Long id) {
        thingRepository.deleteById(id);
    }
}
