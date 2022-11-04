package com.lauraverhoeven.mijnboekenapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MijnBoekenAppController {

    List<Book> mijnBoeken = new ArrayList<>();

    @GetMapping("/")
    public String bookForm(Model model, @RequestParam(required = false) String title){
        model.addAttribute("book", getBookIndex(title) == -1000 ? new Book() : mijnBoeken.get(getBookIndex(title)));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Book book){
        int index = getBookIndex(book.getTitle());
        if(index == -1000){
            mijnBoeken.add(book);
        } else {
            mijnBoeken.set(index, book);
        }
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", mijnBoeken);
        return "books";
    }

    public Integer getBookIndex(String title){
        for (int i = 0; i < mijnBoeken.size(); i++){
            if(mijnBoeken.get(i).getTitle().equalsIgnoreCase(title)) return i;
        }
        return -1000;
    }

}
