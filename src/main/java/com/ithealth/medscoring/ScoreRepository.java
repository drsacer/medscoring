package com.ithealth.medscoring;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {

    //findall
    //List<Score> findAll();
}
