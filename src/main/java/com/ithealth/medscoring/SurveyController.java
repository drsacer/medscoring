package com.ithealth.medscoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller


public class SurveyController {

    @Autowired
    RecordRepository recordRepository;

  /*  @GetMapping("/init")
    public String init (Model model) {
        Record newRecord = new Record ();
        recordRepository.save (newRecord);
        model.addAttribute("newRecord", newRecord);

        return "survey2page1.html";

    }

    @GetMapping("/page1submit")
    public String page1submit (Model model, long recordId, String gender) {
        Record record = recordRepository.findById(record);
        record.setGender(gender.equals("male") ? 1 : 2);

        model.addAttribute("record", record);

        return "survey2page2.html";

    } */
}
