package edu.pusan.example.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pusan.example.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class NoticeController {
    private final NoticeService noticeService;

    @GetMapping("/noticeListPage")
    public String noticeListPage(Model model){
        model.addAttribute("noticeList", noticeService.getNoticeList());
        return "noticeList";
    }
}
