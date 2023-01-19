package com.yarikonen.web44.Services;

import com.yarikonen.web44.Annotations.LogEntryExit;
import com.yarikonen.web44.Data.Dot;
import com.yarikonen.web44.Repositories.DotRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DotService {
    private final DotRepository repository;
    @Autowired
    public DotService(DotRepository dotRepository){
        this.repository=dotRepository;

    }
    @LogEntryExit
    public List<Dot> getDots(){
        return repository.findAll();
    }

    @LogEntryExit
    public Dot addDot(Dot dot){
        dot.setBirthTime(LocalTime.now());
        return(repository.save(dot));
    }
}
