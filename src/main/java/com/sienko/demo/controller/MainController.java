package com.sienko.demo.controller;

import com.sienko.demo.model.Action;
import com.sienko.demo.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {

    private final ActionRepository actionRepository;

    @Autowired
    public MainController(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewAction(@RequestParam int userId,
                        @RequestParam int gameId,
                        @RequestParam String actionDescription) {
        var action = new Action();
        action.setUserId(userId);
        action.setGameId(gameId);
        action.setActionDescription(actionDescription);

        actionRepository.save(action);

        return "Saved action";
    }

    @GetMapping(path = "/viewAll")
    public @ResponseBody
    Iterable<Action> getAllActions() {
        return actionRepository.findAll();
    }
}
