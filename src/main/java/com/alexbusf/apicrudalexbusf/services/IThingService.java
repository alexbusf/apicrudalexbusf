package com.alexbusf.apicrudalexbusf.services;

import com.alexbusf.apicrudalexbusf.models.Thing;

import java.util.List;

public interface IThingService {
    List<Thing> getAll();
    Thing getById(Long id);
    Thing save(Thing thing);
    void delete(Long id);
}
