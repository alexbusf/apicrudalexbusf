package com.alexbusf.apicrudalexbusf.controllers;

import com.alexbusf.apicrudalexbusf.models.Thing;
import com.alexbusf.apicrudalexbusf.services.ThingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ThingController {

    @Autowired
    private ThingService thingService;

    @GetMapping("/things")
    public  ResponseEntity<Object> getAllThings(){
        try {
            Iterable<Thing> things = thingService.getAll();
            return new ResponseEntity<Object>(things, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/things/{id}")
    public ResponseEntity<Object> getThingById(@PathVariable("id") Long id) {
        try {
            Thing thing = thingService.getById(id);
            if(thing != null) {
                return new ResponseEntity<Object>(thing, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/things")
    public ResponseEntity<Object> createThing(@RequestBody Thing thing){
        try {
            Thing savedThing = thingService.save(thing);
            return new ResponseEntity<Object>(savedThing, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/things/{id}")
    public ResponseEntity<Object> updateThing(@PathVariable Long id, @RequestBody Thing thing){
        try {
            thing.setId(id);
            Thing savedThing = thingService.save(thing);
            return new ResponseEntity<Object>(savedThing, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/things/{id}")
    public ResponseEntity<HttpStatus> deleteThing(@PathVariable Long id){
        try{
            thingService.delete(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}
