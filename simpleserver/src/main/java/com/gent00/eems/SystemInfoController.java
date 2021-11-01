package com.gent00.eems;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller

public class SystemInfoController {

    @GetMapping(value = "/system-information", produces = "application/json" )
    @ResponseBody
    public Map<String, String> index() {
        return System.getenv();
    //curl "http://localhost:8080/pkg-war-wildfly-0.1.0-SNAPSHOT/system-information" -H 'Accept: application/json'
    }

    @GetMapping(value = "/system-information" , produces = "text/html")
    public String systeminfo(Model model) {
        model.addAttribute("jvm_env", System.getenv());
        model.addAttribute("milli", System.currentTimeMillis());
        return "sys-info";
    //curl "http://localhost:8080/pkg-war-wildfly-0.1.0-SNAPSHOT/system-information" -H 'Accept: text/html'
    }
}
