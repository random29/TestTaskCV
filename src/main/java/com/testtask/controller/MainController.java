package com.testtask.controller;

import com.testtask.entity.CVEntity;
import com.testtask.service.CVService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class MainController {

    private final CVService cvService;

    public MainController(CVService cvService) {
        this.cvService = cvService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cvs", cvService.findAll());
        return "index";
    }

    @GetMapping("/add-cv")
    public String getAdd() {
        return "add-cv";
    }

    @PostMapping("/add-cv")
    public String add(@ModelAttribute CVEntity cvEntity) {
        cvEntity.setId(UUID.randomUUID());
        cvEntity.setDate(LocalDateTime.now());
        cvService.add(cvEntity);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable UUID id, Model model) {
        model.addAttribute("cv", cvService.findByIdOrEmpty(id));
        return "cv";
    }

    @PostMapping("/{id}/remove")
    public String remove(@PathVariable UUID id) {
        cvService.removeById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable UUID id, Model model) {
        model.addAttribute("cv", cvService.findByIdOrEmpty(id));
        return "cv-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable UUID id, @ModelAttribute CVEntity cvEntity) {
        CVEntity original = cvService.findByIdOrEmpty(id);
        original.setName(cvEntity.getName());
        original.setContent(cvEntity.getContent());
        cvService.add(original);
        return "redirect:/";
    }
}
