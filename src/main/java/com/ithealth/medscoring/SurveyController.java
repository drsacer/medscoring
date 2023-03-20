package com.ithealth.medscoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    public int score;
    public String colorGreen = "#00FF00";
    public String colorRed = "#FF0000";
    public String colorOrange = "#FFA500";

    @Autowired
    RecordRepository recordRepository;

    /* na init se stvara novi zapis s id-om (Record record = new Record() automstski stvara novi record s id-om)
    * init vraća stranicu landingpage na kojoj se nalazi hidden input record.id i button započni
    * klikom na button poziva se metoda /showfirstpage kojoj se proslijeđuje record.id  po kojem se pronalazi zapis,
    * dodaje u model kako bi se mogao prebaciti u html  /survey2page1 */
    @GetMapping("/init")
    public String init (Model model) {
        Record record = new Record();
        recordRepository.save (record);
        model.addAttribute("record", record);
        System.out.println("Rerord ID:" + record.getId());

        return "landingpage.html";
    }

    @GetMapping("/show_page1_gender")
    public String showfirstpage (Model model, Long recordId){
        Record record = recordRepository.findById(recordId).get();
        model.addAttribute("record",record); // attributeName se mora isto zvati record

        return "survey2page1_gender.html";
    }

    @GetMapping("/page1_gender")
    public String page1submit (Model model, long recordId, String gender) {
        Record record = recordRepository.findById(recordId).get();


        record.setGender(gender);
       // record.setGender(gender.equals("male") ? "Male" : "Female");
        recordRepository.save(record);

        model.addAttribute("record", record);
        return "survey2page2_age.html";
    }

    @GetMapping("/page2_age")
    public String page2submit(Model model, long recordId, String age){
        Record record = recordRepository.findById(recordId).get();
        record.setAge(age);

        if(record.getGender().equals("female") && age.equals("more than 60")) score+=10;
        recordRepository.save(record);

        if(age==null){
            String obavezniUnos = "Morate odabrati jednu od opcija!";
            model.addAttribute("obavezniUnos",obavezniUnos);
            model.addAttribute("record", record);
            return "survey2page2_age.html";
        }

        System.out.println("Test");

        model.addAttribute("record", record);
        return "survey2page3_smoker.html";
    }

    @GetMapping("/page3_smoker")
    public String page3submit(Model model, String smoker, long recordId){
        Record record = recordRepository.findById(recordId).get();
        record.setSmoker(smoker);
        recordRepository.save(record);

        if(smoker.equals("yes") || smoker.equals("sometimes")){
            score+=-1;
            model.addAttribute("record", record);
            model.addAttribute("score", score);
            return "survey2page4_daily_smoking.html";
        }
        else {
            score+=3;
            model.addAttribute("record", record);
            model.addAttribute("score", score);
            return "survey2page6_not_smoking.html";
        }
    }
    @GetMapping("/page4_daily_smoking")
    public String page4submit(Model model, String dailycigarettessmoker, String smokingduration, long recordId){
        Record record = recordRepository.findById(recordId).get();
        record.setDailycigarettessmoker(dailycigarettessmoker);
        record.setSmokingduration(smokingduration);
        recordRepository.save(record);

        if (dailycigarettessmoker.equals("lessthanfive")) score+=-1;
        else if (dailycigarettessmoker.equals("fivetoten")) score+=-2;
        else if (dailycigarettessmoker.equals("tentotwenty")) score+=-3;
        else if (dailycigarettessmoker.equals("twentytothirty")) score+=-4;
        else score+=-5;

        model.addAttribute(record);
        model.addAttribute("score", score);

        return "survey2page5_weekly_smoking.html";
    }
    @GetMapping("/page5_weekly_smoking")
    public String page5submit(Model model, String weeklycigarettes, long recordId){
        Record record = recordRepository.findById(recordId).get();
        record.setWeeklycigarettes(weeklycigarettes);
        recordRepository.save(record);

        model.addAttribute(record);
        model.addAttribute("score", score);

        return "survey2page7_bmi.html";
    }

    @GetMapping("/page6_not_smoking")
    public String page6submit(Model model, String stoppedsmoking, String dailycigarettesquit, long recordId){
        Record record = recordRepository.findById(recordId).get();
        record.setStoppedsmoking(stoppedsmoking);
        record.setDailycigarettesquit(dailycigarettesquit);
        recordRepository.save(record);

        model.addAttribute(record);
        model.addAttribute("score", score);
        return "survey2page7_bmi.html";
    }

    @GetMapping("/page7_bmi")
    public String page7bmi(Model model){
        String color;
        String text;
        if(score < 0) {
            color = colorRed;
            text="Visoki rizik";
        }
        else if (score > 0 && score < 6){
            color = colorOrange;
            text="Srednji rizik";
        }
        else {
            color = colorGreen;
            text="Mali rizik";
        }

        model.addAttribute("color", color);
        model.addAttribute("text", text);
        return "score.html";
    }

    @GetMapping ("/bmi_calculate")
    public String bmi_calculate (Model model, long recordId, float bmiHeight, float bmiWeight) {
        Record record = recordRepository.findById(recordId).get();

        double bmi = bmiWeight / Math.pow(bmiHeight/100,2);

        if (record.getGender().equals("male")) {
            if (bmi < 20 || bmi > 25) score += -3;
            else score += 3;
        } else if (record.getGender().equals("female")) {
            if (bmi < 19 || bmi > 24) score += -3;
            else score += 3;
        }

        model.addAttribute("bmi", bmi);
        model.addAttribute(record);
        return "survey2page7_bmi.html";
    }

}
