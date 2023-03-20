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
    public String page1submit (Model model, Long recordId, String gender) {
        Record record = recordRepository.findById (recordId).get ();
        record.setGender (gender.equals ("male") ? "Muško" : "Žensko");
        recordRepository.save (record);

        model.addAttribute ("record", record);

        if (gender.equals ("male")) {
            return "survey2page2.html";
        }else {
            return "survey2page14.html";
        }
    }

    @GetMapping("/page2submit")
    public String page2submit (Model model, Long recordId, String age) {
        Record record = recordRepository.findById (recordId).get ();
        switch (age) {
            case "lessthantwenty" -> record.setAge ("do 20 godina");
            case "21to30" -> record.setAge ("21-30 godina");
            case "31to45" -> record.setAge ("31-45 godina");
            case "46to59" -> record.setAge ("46-59 godina");
            case "morethan60" -> record.setAge ("više od 60 godina");
            default -> record.setAge ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page3.html";

    }

    @GetMapping("/page3submit")
    public String page3submit (Model model, Long recordId, String smoking) {
        Record record = recordRepository.findById (recordId).get ();
        switch (smoking) {
            case "yes" -> record.setSmoking ("Da");
            case "ex" -> record.setSmoking ("Bivši");
            case "sometimes" -> record.setSmoking ("Povremeno");
            case "no" -> record.setSmoking ("Ne");
            default -> record.setSmoking ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return switch (smoking) {
            case "yes" -> "survey2page4.html";
            case "ex" -> "survey2page6.html";
            case "sometimes" -> "survey2page5.html";
            default -> "survey2page7.html";
        };
    }

    @GetMapping("/page4submit")
    public String page4submit (Model model, Long recordId, String dailycigarettessmoker, String smokingduration) {
        Record record = recordRepository.findById (recordId).get ();
        switch (dailycigarettessmoker) {
            case "lessthanfive" -> record.setDailycigarettessmoker ("manje od 5 cigareta");
            case "fivetoten" -> record.setDailycigarettessmoker ("5-10 cigareta");
            case "tentotwenty" -> record.setDailycigarettessmoker ("10-20 cigareta");
            case "twentytothirty" -> record.setDailycigarettessmoker ("20-30 cigareta");
            case "morethanthirty" -> record.setDailycigarettessmoker ("više od 30 cigareta");
            default -> record.setDailycigarettessmoker ("Krivi unos");
        }
        recordRepository.save (record);

        switch (smokingduration) {
            case "lessthanthreemonths" -> record.setSmokingduration ("manje od 3 mjeseca");
            case "lessthanayear" -> record.setSmokingduration ("manje od godinu dana");
            case "lessthanthreeyears" -> record.setSmokingduration ("manje od 3 godine");
            case "lessthansixyears" -> record.setSmokingduration ("manje od 6 godina");
            case "morethansixyears" -> record.setSmokingduration ("više od 6 godina");
            default -> record.setSmokingduration ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page7.html";
    }

    @GetMapping("/page5submit")
    public String page5submit (Model model, Long recordId, String weeklycigarettes) {
        Record record = recordRepository.findById (recordId).get ();
        switch (weeklycigarettes) {
            case "lessthanfive" -> record.setWeeklycigarettes ("manje od 5 cigareta");
            case "fivetoten" -> record.setWeeklycigarettes ("5-10 cigareta");
            case "tentotwenty" -> record.setWeeklycigarettes ("10-20 cigareta");
            case "twentytothirty" -> record.setWeeklycigarettes ("20-30 cigareta");
            case "morethanthirty" -> record.setWeeklycigarettes ("više od 30 cigareta");
            default -> record.setWeeklycigarettes ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page7.html";
    }

    @GetMapping("/page6submit")
    public String page6submit (Model model, Long recordId, String stoppedsmoking, String dailycigarettesquit) {
        Record record = recordRepository.findById (recordId).get ();
        switch (stoppedsmoking) {
            case "thirtyyearsago" -> record.setStoppedsmoking ("prije 30 godina");
            case "twentyyearsago" -> record.setStoppedsmoking ("prije 20 godina");
            case "tentotwentyyears" -> record.setStoppedsmoking ("između 10 i 20 godina");
            case "fiveyearsago" -> record.setStoppedsmoking ("prije 5 godina");
            case "oneyearago" -> record.setStoppedsmoking ("prije godinu dana");
            default -> record.setStoppedsmoking ("Krivi unos");
        }
        recordRepository.save (record);

        switch (dailycigarettesquit) {
            case "lessthanfive" -> record.setDailycigarettesquit ("manje od 5 cigareta");
            case "fivetoten" -> record.setDailycigarettesquit ("5-10 cigareta");
            case "tentotwenty" -> record.setDailycigarettesquit ("10-20 cigareta");
            case "twentytothirty" -> record.setDailycigarettesquit ("20-30 cigareta");
            case "morethanthirty" -> record.setDailycigarettesquit ("više od 30 cigareta");
            default -> record.setDailycigarettesquit ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page7.html";
    }

    @GetMapping("/page7submit")
    public String page7submit (Model model, Long recordId, String bmi) {
        Record record = recordRepository.findById (recordId).get ();
        switch (bmi) {
            case "underweight" -> record.setBmi ("do 19.0 kg/m2 (pothranjenost)");
            case "ideal" -> record.setBmi ("19-25 kg/m2 (normalno)");
            case "slightlyhigh" -> record.setBmi ("25-30 kg/m2 (blago povišeno)");
            case "overweight" -> record.setBmi ("30-35 kg/m2 (višak kilograma)");
            case "obese" -> record.setBmi ("veće od 35 kg/m2 (pretilost)");
            default -> record.setBmi ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page8.html";
    }

    @GetMapping("/page8submit")
    public String page8submit (Model model, Long recordId, String alcohol) {
        Record record = recordRepository.findById (recordId).get ();
        switch (alcohol) {
            case "doesntdrink" -> record.setAlcohol ("Ne pijem");
            case "onedl" -> record.setAlcohol ("1dl dnevno");
            case "twotothreedl" -> record.setAlcohol ("2-3dl dnevno");
            case "fivedl" -> record.setAlcohol ("5dl dnevno");
            case "morethanonel" -> record.setAlcohol ("više od 1L dnevno");
            default -> record.setAlcohol ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page9.html";
    }

    @GetMapping("/page9submit")
    public String page9submit (Model model, Long recordId, String activity) {
        Record record = recordRepository.findById (recordId).get ();
        switch (activity) {
            case "active" -> record.setActivity ("3-4- tjedno 30 -40 min, fizički posao");
            case "moderatelyactive" -> record.setActivity ("2-3 puta tjedno, fizički posao");
            case "lessactive" -> record.setActivity ("2-3-puta tjedno, sjedeći posao");
            case "notveryactive" -> record.setActivity ("Jednom mjesečno, sjedeći posao");
            case "notactive" -> record.setActivity ("Ne krećem se, sjedeći posao");
            default -> record.setActivity ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page10.html";
    }

    @GetMapping("/page10submit")
    public String page10submit (Model model, Long recordId, String CV, String diabetes, String heart, String bloodpressure, String stroke) {
        Record record = recordRepository.findById (recordId).get ();
        switch (CV) {
            case "noCV" -> record.setCV ("Nema CV bolesti");
            case "onerelative" -> record.setCV ("1 rođak sa CV bolesti");
            case "tworelatives" -> record.setCV ("2 rođaka sa CV bolesti");
            case "threerelativesmorethansixty" -> record.setCV ("3 rođaka sa CV bolesti koji su stariji od 60 godina");
            case "threerelativeslessthansixty" -> record.setCV ("3 rođaka koji su mlađi od 60 godina");
            default -> record.setCV ("Krivi unos");
        }
        recordRepository.save (record);

        switch (diabetes) {
            case "none" -> record.setDiabetes ("Nemam");
            case "onerelative" -> record.setDiabetes ("1 rođak (drugo koljeno)");
            case "tworelatives" -> record.setDiabetes ("2 rođaka(drugo koljeno)");
            case "yesaftertwenty" -> record.setDiabetes ("Javila mi se šećerna bolest nakon 20. godine");
            case "yesbeforesixty" -> record.setDiabetes ("Javila mi se šećerna bolest prije 60. godine");
            default -> record.setDiabetes ("Krivi unos");
        }
        recordRepository.save (record);

        switch (heart) {
            case "normal" -> record.setHeart ("Nemam");
            case "sometimes" -> record.setHeart ("Povremeno lupanje srca");
            case "yesbutonmeds" -> record.setHeart ("Da, ali koristim lijekove");
            case "allthetime" -> record.setHeart ("Stalno");
            default -> record.setHeart ("Krivi unos");
        }
        recordRepository.save (record);

        switch (bloodpressure) {
            case "no" -> record.setBloodpressure ("Ne");
            case "onerelative" -> record.setBloodpressure ("1 rođak (drugo koljeno)");
            case "tworelatives" -> record.setBloodpressure ("2 rođaka (drugo koljeno)");
            case "motherorfather" -> record.setBloodpressure ("Majka ili otac");
            case "motherandfather" -> record.setBloodpressure ("Majka i otac");
            default -> record.setBloodpressure ("Krivi unos");
        }
        recordRepository.save (record);

        switch (stroke) {
            case "no" -> record.setStroke ("Ne");
            case "onerelative" -> record.setStroke ("1 rođak (drugo koljeno)");
            case "tworelatives" -> record.setStroke ("2 rođaka (drugo koljeno)");
            case "motherorfather" -> record.setStroke ("Majka ili otac");
            case "motherandfather" -> record.setStroke ("Majka i otac");
            default -> record.setStroke ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page11.html";
    }

    @GetMapping("/page11submit")
    public String page11submit (Model model, Long recordId, String cholesterol, String LDL) {
        Record record = recordRepository.findById (recordId).get ();
        switch (cholesterol) {
            case "dontknow" -> record.setCholesterol ("Neznam");
            case "lessthanfive" -> record.setCholesterol ("manje od 5 mmol/L");
            case "lessthansix" -> record.setCholesterol ("manje od 6 mmol/L");
            case "lessthaneight" -> record.setCholesterol ("manje od 8 mmol/L");
            case "lessthannine" -> record.setCholesterol ("manje od 9 mmol/L");
            default -> record.setCholesterol ("Krivi unos");
        }
        recordRepository.save (record);

        switch (LDL) {
            case "dontknow" -> record.setLDL ("Neznam");
            case "lessthanthree" -> record.setLDL ("manje od 3 mmol/L");
            case "lessthanfour" -> record.setLDL ("manje od 4 mmol/L");
            case "lessthanfive" -> record.setLDL ("manje od 5 mmol/L");
            case "lessthansix" -> record.setLDL ("manje od 6 mmol/L");
            default -> record.setLDL ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page12.html";
    }

    @GetMapping("/page12submit")
    public String page12submit (Model model, Long recordId, String systolic, String diastolic, String heartbeat) {
        Record record = recordRepository.findById (recordId).get ();
        switch (systolic) {
            case "low" -> record.setSystolic ("manji od 120 mmhg");
            case "normal" -> record.setSystolic ("do 130 mmHg");
            case "slightlyelevated" -> record.setSystolic ("do 140 mmHg");
            case "elevated" -> record.setSystolic ("do 170 mmHg");
            case "high" -> record.setSystolic ("iznad 180 mmHg");
            default -> record.setSystolic ("Krivi unos");
        }
        recordRepository.save (record);

        switch (diastolic) {
            case "low" -> record.setDiastolic ("manji od 80 mmHg");
            case "normal" -> record.setDiastolic ("80-84 mmHg");
            case "slightlyelevated" -> record.setDiastolic ("85-89 mmHg");
            case "elevated" -> record.setDiastolic ("90-109 mmHg");
            case "high" -> record.setDiastolic ("Iznad 110 mmHg");
            default -> record.setDiastolic ("Krivi unos");
        }
        recordRepository.save (record);

        switch (heartbeat) {
            case "low" -> record.setHeartbeat ("60-74 otkucaja/min");
            case "normal" -> record.setHeartbeat ("74-90 otkucaja/min");
            case "slightlyelevated" -> record.setHeartbeat ("90-100 otkucaja/min");
            case "elevated" -> record.setHeartbeat ("100-120 otkucaja/min");
            case "high" -> record.setHeartbeat ("veći od 120 otkucaja/min");
            default -> record.setDiastolic ("Krivi unos");
        }

        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page13.html";
    }

    @GetMapping("/page13submit")
    public String page13submit (Model model, Long recordId, String chronic, String medication) {
        Record record = recordRepository.findById (recordId).get ();
        switch (chronic) {
            case "none" -> record.setChronic ("Nemam kroničnih bolesti");
            case "yes" -> record.setChronic ("Da");
            case "no" -> record.setChronic ("Ne");
            default -> record.setChronic ("Krivi unos");
        }
        recordRepository.save (record);

        if (medication.equals ("yes")) {
            record.setMedication ("Da");
        } else if (medication.equals ("no")) {
            record.setMedication ("Ne");
        } else {
            record.setMedication ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "finalpage.html";
    }

    @GetMapping("/page14submit")
    public String page14submit (Model model, Long recordId, String migraine, String hormonaltherapy, String eclampsia, String pregnant) {
        Record record = recordRepository.findById (recordId).get ();
        switch (migraine) {
            case "no" -> record.setSystolic ("Ne");
            case "notwoyears" -> record.setSystolic ("Nisam imala migrenu već 2 godine");
            case "coupletimesayear" -> record.setSystolic ("Javlja mi se nekoliko puta godišnje");
            case "onceamonth" -> record.setSystolic ("Javlja mi se barem jednom mjesečno");
            case "often" -> record.setSystolic ("Često imam migrene");
            default -> record.setSystolic ("Krivi unos");
        }
        recordRepository.save (record);

        switch (hormonaltherapy) {
            case "no" -> record.setDiastolic ("Ne");
            case "stoppedbeforefiveyears" -> record.setDiastolic ("Prestala prije 5 i više godina");
            case "stoppedmorethanayear" -> record.setDiastolic ("Prestala između 5 i godinu dana");
            case "useitlessthanfiveyears" -> record.setDiastolic ("oristim hormonalnu terapiju manje od 5 godina");
            case "useitmorethanfiveyears" -> record.setDiastolic ("Koristim terapiju 5 i više godina");
            default -> record.setDiastolic ("Krivi unos");
        }
        recordRepository.save (record);

        switch (eclampsia) {
            case "no" -> record.setHeartbeat ("Ne");
            case "onecousin" -> record.setHeartbeat ("1 sestrična");
            case "twocousins" -> record.setHeartbeat ("2 sestrične");
            case "mother" -> record.setHeartbeat ("Majka");
            case "sister" -> record.setHeartbeat ("Sestra");
            default -> record.setDiastolic ("Krivi unos");
        }

        switch (pregnant) {
            case "yes" -> record.setHeartbeat ("Da");
            case "no" -> record.setHeartbeat ("Ne");
            default -> record.setDiastolic ("Krivi unos");
        }
        recordRepository.save (record);

        model.addAttribute ("record", record);

        return "survey2page2.html";
    }

    // UTITILTY METHOD

    @GetMapping("/")
    public String redirectToLandingPage () {

        return "redirect:/init";
    }
}
