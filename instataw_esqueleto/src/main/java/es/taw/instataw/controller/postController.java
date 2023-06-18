package es.taw.instataw.controller;

import es.taw.instataw.entity.Post;
import es.taw.instataw.repositories.postRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class postController {
    @Autowired
    protected postRepository postRepository;

    @GetMapping("/instataw/IT")
    public String doListar(@RequestParam("usr")String usr, Model model){
        List<Post> listapost = this.postRepository.findAll();
        model.addAttribute("listapost",listapost);
        return "listar";
    }
}
