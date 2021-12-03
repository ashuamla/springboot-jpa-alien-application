package com.ashu.springbootapp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AlienController {
    @Autowired
    AlienMethods am;

    @GetMapping("/")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String save(Alien alien){
        am.save(alien);
        return "home.jsp";
    }
    
    // @RequestMapping("/getAlien")
    // public ModelAndView getAlien(@RequestParam int aid){
    //     ModelAndView mv = new ModelAndView("showAlien.jsp");
    //     Alien alien = am.findById(aid).orElse(new Alien());
    //     System.out.println(am.findByAname("Shakti"));
    //     //System.out.println(am.findByAidGreaterThan(2));
    //     mv.addObject(alien);
    //     return mv;
    @GetMapping("/aliens")
    public List<Alien> getAlien()
    {
        return am.findAll();
    }

    @GetMapping("/aliens/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int  aid)
    {
        return am.findById(aid);
    }
    @PostMapping("/aliens")
    public Alien addAlien(@RequestBody Alien alien)
    {
        am.save(alien);
        return alien;
    }
    @DeleteMapping("/aliens/{aid}")
    public String deleteAlien(@PathVariable("aid") int aid)
    {
        am.deleteById(aid);
        return "Sucessfully deleted "+aid;
    }
    @PutMapping("/alien")
    public Alien updateAlien(@RequestBody Alien alien)
    {
        am.save(alien);
        return alien;
    }

}

