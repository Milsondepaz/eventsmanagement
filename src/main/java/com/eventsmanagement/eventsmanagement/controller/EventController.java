package com.eventsmanagement.eventsmanagement.controller;

import com.eventsmanagement.eventsmanagement.model.Event;
import com.eventsmanagement.eventsmanagement.model.Guest;
import com.eventsmanagement.eventsmanagement.repository.EventRepository;
import com.eventsmanagement.eventsmanagement.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/*
heroku login
git init
git add .
git commit -m "Initial commit"
heroku create <app-name>
git push heroku master
heroku open
*/


@Controller
@RequestMapping
public class EventController {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/")
    public String home( ) {
        //ModelAndView mv = new ModelAndView("eventList");
        //Iterable<Event> listEvents = eventRepository.findAll();
        //mv.addObject("listEvents", listEvents);
        return "index";
    }

    @GetMapping("/eventList")
    public ModelAndView eventList( ) {
        ModelAndView mv = new ModelAndView("eventList");
        Iterable<Event> listEvents = eventRepository.findAll();
        mv.addObject("listEvents", listEvents);
        return mv;
    }

    @GetMapping("/registerEvent")
    public String registerEvent() {
        return "registerEvent";
    }

    @PostMapping("/registerEvent")
    public String registerEventPost(@Valid Event event, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("message ", "Please check the blank fields");
            return "redirect:/registerEvent";
        } else {
            eventRepository.save(event);
            model.addAttribute("message ", "Saved successfully");
            return "redirect:";
        }
    }


    @RequestMapping("/{id}")
    public ModelAndView eventDetails(@PathVariable("id") long id) {
        Event event = eventRepository.findById(id);
        ModelAndView mv = new ModelAndView("eventDetails"); //uma view que vai apresentar os detalhes dos eventos
        mv.addObject("event", event);
        Iterable<Guest> guestList = guestRepository.findByEvent(event);
        mv.addObject("guestList", guestList);
        return mv;
    }

    @RequestMapping("/delete")
    public String eventDelete(long id) {
        Event event = eventRepository.findById(id);
        if (event.guestList.size() == 0) {
            eventRepository.delete(event);
        }
        return "redirect:"; // redirect for Main page - index - the localhost
    }

    @RequestMapping("/deleteGuest")
    public String deleteGuest(String idNumber) {
        Guest guest = guestRepository.findByIdNumber(idNumber);
        guestRepository.delete(guest);
        Event event = guest.getEvent();
        long id = event.getId();
        return "redirect:/"+String.valueOf(id);
    }

    @PostMapping("/{id}")
    public String addGuest(@PathVariable("id") long id, @Valid Guest guest, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addAttribute("message ", "Pleace check the fields");
            return "redirect:/{id}";
        }
        Event event = eventRepository.findById(id);
        guest.setEvent(event);
        guestRepository.save(guest);
        attributes.addAttribute("messagem ", "Guest added successfully!");
        return "redirect:/{id}";
    }



}
