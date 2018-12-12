package com.service.provider.controller;

import com.service.provider.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-04 11:55
 */
@RestController
public class MyController {

    @GetMapping("exchange")
    public String exchange(String name, String add) {
        return name + add;
    }

    @PostMapping("/body")
    public String body(@RequestBody User user) throws IOException {
        String str="姓名:" + user.getUsername() + ",年龄:" + user.getAge() + ",birth:" + user.getBirth();
        System.out.println(str);
        return str;
    }
}
