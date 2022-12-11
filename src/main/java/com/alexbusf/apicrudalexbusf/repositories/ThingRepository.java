package com.alexbusf.apicrudalexbusf.repositories;

import com.alexbusf.apicrudalexbusf.models.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<Thing, Long> {
}
