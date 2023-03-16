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
        Record record = new Record ();
        recordRepository.save (record);
        model.addAttribute ("record", record);

        return "landingpage.html";
    }

    @GetMapping("/showpage1")
    public String showPage1 (Model model, Long recordId) {
        model.addAttribute ("record", recordRepository.findById (recordId).get ());

        return "survey2page1.html";
    }

    @GetMapping("/page1submit")
    public String page1submit (Model model, long recordId, String gender) {
        Record record = recordRepository.findById (recordId).get ();
        record.setGender (gender.equals ("male") ? "Muško" : "Žensko");
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page2.html";
    }
}
