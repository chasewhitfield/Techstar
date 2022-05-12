package com.amidos.EmailDemo.EndpointController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amidos.EmailDemo.Intern.Intern;




@Controller
public class EndpointController {
	
	@RequestMapping(path = "/sendEmail/{email}", method= RequestMethod.POST)
	public String postComment(@PathVariable String email ,@RequestBody String text) {
	System.out.println(email);
	System.out.println(text);
	try {
	System.out.println("readStart");
	File reader = new File("data.csv");
	Scanner scan = new Scanner(reader);
	while(scan.hasNextLine()) {
	System.out.println(scan.nextLine());
	}
	scan.close();
	FileWriter writer = new FileWriter("data.csv");
	writer.write(text);
	writer.close();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return "okay";
	}
	
}



