package tsoy.sergey.springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tsoy.sergey.springCrud.models.User;
import tsoy.sergey.springCrud.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/userById";
    }

//    @GetMapping("/newUser") // получаем форму для создания нового юзера
//    public String newUser(Model model) { // через пустого new User()
//        model.addAttribute("user", new User());
//        return "users/new";
//    }

    @GetMapping("/newUser") // получаем форму для создания нового юзера
    public String newUser(@ModelAttribute("user") User user) {// то же самое через @ModelAttribute
        return "users/newUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @ModelAttribute("headerMessage") // @ModelAttribute на методе делает доступной в каждой модели класса пару:
    public String header() {         // key("headerMessage") <--> value("Task 2.3.1 (spring-crud-231)")
        return "Task spring-crud-2.3.1"; // при необходимости можно вывести ее на странице в браузере
    }
}





