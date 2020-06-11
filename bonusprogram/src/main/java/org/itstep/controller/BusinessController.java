package org.itstep.controller;

import org.itstep.domain.Person;
import org.itstep.domain.Transaction;
import org.itstep.repositories.BusinessRepository;
import org.itstep.repositories.TransactionRepository;
import org.itstep.repositories.UserRepository;
import org.itstep.service.TransactionService;
import org.itstep.service.UserService;
import org.itstep.service.dto.TransactionDto;
import org.itstep.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BusinessController {
    final UserService userService;
    final TransactionService transactionService;
    final UserRepository userRepository;
    final BusinessRepository businessRepository;
    final TransactionRepository transactionRepository;

    @Autowired
    public BusinessController(UserService userService, TransactionService transactionService, UserRepository userRepository, BusinessRepository businessRepository, TransactionRepository transactionRepository) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.userRepository = userRepository;
        this.businessRepository = businessRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping(path = "/business/enter")
    public String ent() {
        return "business/enter";
    }

    @GetMapping(path = "/business/account")
    public String account() {
        return "business/account";
    }

    @GetMapping(path = "/business/payments")
    public String payments(Model model, Integer page, Integer size){
        /*Pageable pageable = PageRequest.of(page == null ? 0 : page, size == null ? 10 : size);
        Page<TransactionDto> transactionDtoPage = transactionService.findAll(pageable);
        model.addAttribute("transactions", transactionDtoPage.getContent());*/
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(transactionRepository.findAll());
        model.addAttribute("transactions", transactions);
        //model.addAttribute("page", transactionDtoPage);
        return "business/payments";
    }

    @GetMapping(path = "/business/users")
    public String users(Model model, Integer page, Integer size){
       /*Pageable pageable = PageRequest.of(page == null ? 0 : page, size == null ? 10 : size);
        Page<UserDto> userDtoPage = userService.findAll(pageable);
        model.addAttribute("users", userDtoPage.getContent());*/
        List<Person> users = new ArrayList<>();
        users.addAll(userRepository.findAll());
        model.addAttribute("users", users);//userDtoPage.getContent());
        //model.addAttribute("page", userDtoPage);
        return "business/users";
    }

    private String MSG = "";
    private String BONUS = "";
    private String FIN_SUM = "";
    @GetMapping(path = "/business/addTransaction")
    public String addTransaction(Model model){
        model.addAttribute("state", MSG);
        model.addAttribute("bonus", BONUS);
        model.addAttribute("fin_sum", FIN_SUM);
        MSG = "";
        BONUS = "";
        FIN_SUM = "";
        return "business/addTransaction";
    }

    @PostMapping("/business/addTransaction")
    public String submit(@ModelAttribute("phone") String phone,
                           @ModelAttribute("dirty_sum") String initialSum,
                           @ModelAttribute("bonus_ch") String bonus) {
        try{
            double finalSum = 0.0;
            double allBonus = 0.0;

            for (Transaction t:transactionRepository.findAll()) {
                if(t.getUser().getId().equals(userRepository.findUserByPhone(phone).getId())){
                    allBonus+=t.getAddedBonus();
                    allBonus-=t.getChargedBonus();
                }
            }

            if(bonus.equals("on")){
                if(allBonus>=Double.parseDouble(initialSum)){
                    allBonus = Double.parseDouble(initialSum) * 0.1;
                }
                finalSum = Double.parseDouble(initialSum) - allBonus;
                TransactionDto dto = new TransactionDto(LocalDate.now(), Double.parseDouble(initialSum), Double.parseDouble(initialSum)*0.03, allBonus, finalSum,
                        userRepository.findUserByPhone(phone), businessRepository.findById(1).get());
                transactionService.save(dto);
                BONUS = "ADDED BONUS: " + dto.getAddedBonus();
            }else{
                finalSum = Double.parseDouble(initialSum);
                TransactionDto dto = new TransactionDto(LocalDate.now(), Double.parseDouble(initialSum), Double.parseDouble(initialSum)*0.03, 0.0, finalSum,
                    userRepository.findUserByPhone(phone), businessRepository.findById(1).get());
                transactionService.save(dto);
                BONUS = "ADDED BONUS: " + dto.getAddedBonus();
            }
            FIN_SUM = "TO PAY: " + finalSum;
            MSG ="transaction was added";
        }
        catch(Exception e){
            MSG =  "transaction was not added";
        }
        return "redirect:/business/addTransaction";
    }
}
