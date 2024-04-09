package com.example.demo.springboot.buisinessCalcService;

import java.util.Arrays;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component
@Service
public class BusinessCalcService {

    private DataService dataService;

    public BusinessCalcService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}
