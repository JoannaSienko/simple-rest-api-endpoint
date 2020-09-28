package com.sienko.demo.controller;

import com.sienko.demo.dto.ActionDTO;
import com.sienko.demo.model.Action;
import com.sienko.demo.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

    private final ActionRepository actionRepository;

    @Autowired
    public MainController(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewAction(@RequestBody ActionDTO actionDTO) {
        var action = new Action();
        action.setUserId(actionDTO.getUserId());
        action.setGameId(actionDTO.getGameId());
        action.setActionDescription(actionDTO.getActionDescription());

        actionRepository.save(action);

        return "Saved action";
    }

    @GetMapping(path = "/viewAll")
    public @ResponseBody
    Iterable<Action> getAllActions() {
        return actionRepository.findAll();
    }
}
