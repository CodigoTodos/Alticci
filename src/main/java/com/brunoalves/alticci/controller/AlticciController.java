package com.brunoalves.alticci.controller;

import com.brunoalves.alticci.service.AlticciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/alticci")
public class AlticciController {

    @Autowired
    private AlticciService alticciService;

    @CrossOrigin(origins = {"http://127.0.0.1:5500","http://localhost:5500"})
    @GetMapping("/{sequenceIndex}")
    @Cacheable("cachedIndexes")
    public Long calculateResult(@PathVariable final Long sequenceIndex)  {
        return alticciService.calculateResult(sequenceIndex);

    }

}
