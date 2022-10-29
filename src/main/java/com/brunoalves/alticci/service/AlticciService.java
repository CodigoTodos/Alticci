package com.brunoalves.alticci.service;

import com.brunoalves.alticci.error.SequenceIndexNotValidException;
import org.springframework.stereotype.Service;

@Service
public class AlticciService {

    public Long calculateResult(Long sequenceIndex) {
        if (sequenceIndex < 0)
            throw new SequenceIndexNotValidException(sequenceIndex + " is not a valid Index.");
        if (sequenceIndex == 0)
            return 0L;
        else if (sequenceIndex == 1 || sequenceIndex== 2)
            return 1L;
        return calculateResult(sequenceIndex - 3) + calculateResult(sequenceIndex - 2);
    }
}
