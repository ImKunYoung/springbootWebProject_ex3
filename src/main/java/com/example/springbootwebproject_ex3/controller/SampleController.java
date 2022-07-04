package com.example.springbootwebproject_ex3.controller;

import dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1.......................");
    }

    @GetMapping({"/ex2"}) /* {"/ex2"} => 하나 이상의 url 지정 가능 */
    public void exModel(Model model) {
        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream()
                .mapToObj(i -> SampleDTO.builder()
                        .sno(i)
                        .first("First.." + i)
                        .last("Last.." + i)
                        .regTime(LocalDateTime.now())
                        .build()).collect(Collectors.toList());

        log.info(list);
        model.addAttribute("list", list);
    }
}
