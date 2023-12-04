package edu.pusan.example.center.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pusan.example.center.domain.dto.CenterDto;
import edu.pusan.example.center.service.CenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CenterController {
  private final CenterService centerService;

 @GetMapping("/centerListPage")
 public String centerListPage(Model model) {
   model.addAttribute("centerList", centerService.getCenterList());
   return "centerList";
 }
  

  @GetMapping("/centerInsertPage")
  public String centerInsertPage() {
    return "centerInsert";
  }

  @GetMapping("/centerInfoPage/{centerId}")
  public String centerInfoPage(@PathVariable("centerId") int centerId, Model model) {
    model.addAttribute("center", centerService.getCenter(centerId));
    return "centerInfo";
  }

  @PostMapping("/centerUpdatePage")
  public String centerUpdatePage(int centerId, Model model) {
    model.addAttribute("center", centerService.getCenter(centerId));
    return "centerUpdate";
  }

  @PostMapping("/centerInsert")
  public String centerInsert(CenterDto centerDto) {
    centerService.insertCenter(centerDto);
    return "redirect:/centerListPage";
  }

  @PostMapping("/centerUpdate")
  public String centerUpdate(CenterDto centerDto) {
    centerService.updateCenter(centerDto);
    return "redirect:/centerListPage";
  }

  @PostMapping("/centerDelete")
  public String centerDelete(int centerId) {
    centerService.deleteCenter(centerId);
    return "redirect:/centerListPage";
  }


}

