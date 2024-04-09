package com.example.demo.springboot.buisinessCalcService;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

// @Component
@Repository
public class MySqlDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }

}
