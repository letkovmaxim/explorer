package org.explorer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
public class ExplorerController {

    Explorer explorer = new Explorer();

    @GetMapping("/")
    public String showExplorer(Model model) {
        model.addAttribute("explorer", explorer);
        return "index";
    }

    @PostMapping("/")
    public String postExplorer(@RequestParam(value = "param") String path) {
        if (path.equals("root")) {
            explorer = new Explorer(File.listRoots());
        } else {
            explorer = new Explorer(path);
        }
        return "redirect:/";
    }
}
