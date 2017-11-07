package org.vinci.spring.sessionlearn.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.vinci.commons.core.serializer.jackson.NameValue;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by XizeTian on 2017/11/6.
 */
@RestController
@RequestMapping("/home")
@CrossOrigin
public class HomeController {
    @Autowired
    HttpSession session;

    @GetMapping("/blank")
    public void blank() {

    }

    @GetMapping("/session-id")
    public String home() {
        return session.getId();
    }

    @PostMapping("/name-value")
    public void setValue(@RequestBody List<NameValue<String, Object>> nvLst) {
        for (NameValue<String, Object> nameValue : nvLst) {
            session.setAttribute(nameValue.name(), nameValue.value());
        }
    }

    @RequestMapping(value = "/name-value-part", method = RequestMethod.POST)
    public void setValuePart(String data) throws IOException {
        List<NameValue<String, Object>> nvLst = new ArrayList<>();

        List lst = new ObjectMapper().readValue(data, List.class);
        for (Object o : lst) {
            Map map = (Map) o;
            nvLst.add(new NameValue<>(String.valueOf(map.get("name")), map.get("value")));
        }
        setValue(nvLst);
    }

    @GetMapping("/name-value")
    public List<HashMap<String, Object>> getValue() {
        List<HashMap<String, Object>> nameValues = new ArrayList<>();

        Enumeration<String> names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(name, session.getAttribute(name));

            nameValues.add(hashMap);
        }

        return nameValues;
    }
}
