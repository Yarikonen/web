package com.yarikonen.web44.Services;

import com.yarikonen.web44.Annotations.LogEntryExit;
import com.yarikonen.web44.Data.Dot;
import com.yarikonen.web44.Repositories.DotRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DotService {
    DotRepository repository;
    @Autowired
    DotService(DotRepository dotRepository){
        this.repository=dotRepository;

    }
    @LogEntryExit
    public List<Dot> getDots(){
        return repository.findAll();
    }
}
