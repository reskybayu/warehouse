package warehouse.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import warehouse.warehouse.repositories.UserRepo;

@Controller
@RequestMapping(value="/user/")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value="index")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("user/index");
        return view;
    }
}
