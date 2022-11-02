package com.lauraverhoeven.mijnboekenapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class MijnBoekenAppApplication {

	public static void main(String[] args) {
		List<Book> Books = CSVReaderInJava.readBooksFromCSV("src/main/resources/static/books/books.csv");
		System.out.println(Books.get(0));

		SpringApplication.run(MijnBoekenAppApplication.class, args);
	}


}

