package com.bank.demo.Controller.view;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.demo.exception.CustomException;
import com.bank.demo.model.BankDto;
import com.bank.demo.service.BankServiceInterface;

import lombok.*;

@Controller
@RequiredArgsConstructor
public class BankViewController {

    private final BankServiceInterface bankService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/all-banks")
    public String showAllBanks(Model model) {

        List<BankDto> banks = bankService.findAllBanks();

        // remove first bank (main bank)
        if (!banks.isEmpty()) {
            banks = banks.subList(1, banks.size());
        }

        model.addAttribute("banks", banks);

        return "allbanks";
    }

    @GetMapping("/register-bank")
    public String showRegisterBankPage(Model model) {
        model.addAttribute("bank", new BankDto());
        return "registerbank";
    }

    @PostMapping("/register-bank")
    public String registerBank(@ModelAttribute("bank") BankDto bankDto, Model model) {
        try {
            bankService.registerBank(bankDto);
            model.addAttribute("bank", new BankDto());
            model.addAttribute("successMessage", "Bank registered successfully.");
        } catch (CustomException ex) {
            model.addAttribute("bank", bankDto);
            model.addAttribute("errorMessage", ex.getMessage());
        }

        return "registerbank";
    }

    @GetMapping("/update-bank/{swiftCode}")
    public String showUpdateBankPage(@PathVariable String swiftCode, Model model) {
        BankDto bank = bankService.getBankBySwiftCode(swiftCode);
        model.addAttribute("bank", bank);
        return "updatebank";
    }

    @PostMapping("/update-bank/{swiftCode}")
    public String updateBank(
            @PathVariable String swiftCode,
            @ModelAttribute("bank") BankDto bankDto,
            Model model) {
        try {
            BankDto updatedBank = bankService.updateBankBySwiftCode(swiftCode, bankDto);
            model.addAttribute("bank", updatedBank);
            model.addAttribute("successMessage", "Bank updated successfully.");
        } catch (CustomException ex) {
            model.addAttribute("bank", bankDto);
            model.addAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/all-banks";
    }

    @PostMapping("/delete-bank/{swiftCode}")
    public String deleteBankBySwiftCode(
            @PathVariable String swiftCode,
            RedirectAttributes redirectAttributes) {

        try {
            bankService.deleteBankBySwiftCode(swiftCode);
            redirectAttributes.addFlashAttribute("successMessage", "Bank deleted successfully.");
        } catch (CustomException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/all-banks";
    }
}