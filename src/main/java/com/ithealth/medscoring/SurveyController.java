package com.ithealth.medscoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller


public class SurveyController {

    @Autowired
    RecordRepository recordRepository;

    @GetMapping("/init")
    public String init (Model model) {
        Record newRecord = new Record ();
        recordRepository.save (newRecord);
        model.addAttribute (newRecord.getId ());

        return "survey2page1.html";

    }
}
