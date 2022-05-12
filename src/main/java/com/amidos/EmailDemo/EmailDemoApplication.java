package com.amidos.EmailDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.amidos.EmailDemo.Intern.Intern;

@SpringBootApplication
public class EmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}
	
	
	 public ArrayList<String> generateCSV () throws FileNotFoundException {
		System.out.println("Now generating csv...");
        ArrayList<Intern> TechStar = generateList("intern.csv");

        Intern a = new Intern("Ivan Brenes", 5, 5, 5, 5, 5, 5, 5,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5
        , 5, 5);
        
        System.out.println("Going through for loop...");
        List<Intern> partners = a.getClosestInterns(TechStar, 2);
        
        ArrayList<String> emails = new ArrayList<>();
        
        for (Intern partner : partners) {
        	String partEmail = partner.generateEmail();
            System.out.println(partEmail);
            emails.add(partEmail);
            System.out.println("Distance from you: " + partner.distanceToOtherIntern(a));
        }
        
        String internEmail = a.generateEmail();
        String potentialEmails = "";
        
        if(emails != null && emails.size() > 0) {
        	
        	StringBuilder builder = new StringBuilder();
        	
        	for(int i = 0; i < emails.size(); i++) {
        		if(i != emails.size() - 1 ) {
        			builder.append(emails.get(i) + ", ");
        		}
        		else {
        			builder.append(emails.get(i) + " and that is all of the emails.");
        		}
        	}
        	
        	potentialEmails = builder.toString();
        	
        	System.out.println("Intern " + a.getName() + " will be getting the email addresses of: " + potentialEmails);
        }
        
        ArrayList<String> internInfo = new ArrayList<>();
        internInfo.add(internEmail);
        internInfo.add(potentialEmails);
        return internInfo;
    }

    static ArrayList<Intern> generateList(String filePath) throws FileNotFoundException {
        ArrayList<Intern> interns = new ArrayList<Intern>();
        File csv = new File(filePath); //might have to change to filepath
        try {
            Scanner sc = new Scanner(csv);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String curRow = sc.nextLine();
                String[] cols = curRow.split(","); //Need to parse out whitespace
                Intern curIntern = new Intern(cols[0], Integer.parseInt(cols[1]), Integer.parseInt(cols[2]), Integer.parseInt(cols[3]), Integer.parseInt(cols[4]), Integer.parseInt(cols[5]),
                        Integer.parseInt(cols[6]), Integer.parseInt(cols[7]), Integer.parseInt(cols[8]), Integer.parseInt(cols[9]),
                        Integer.parseInt(cols[10]), Integer.parseInt(cols[11]), Integer.parseInt(cols[12]), Integer.parseInt(cols[13]),
                        Integer.parseInt(cols[14]), Integer.parseInt(cols[15]), Integer.parseInt(cols[16]), Integer.parseInt(cols[17]),
                        Integer.parseInt(cols[18]), Integer.parseInt(cols[19]));
                interns.add(curIntern);
                System.out.println(curIntern.getName() + " has been added!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
        return interns;
    }
	 
	
	@Autowired
    private JavaMailSender javaMailSender;

    public void run(String... args) {

        System.out.println("Sending Email...");
        //sendEmail();
        System.out.println("Done");

    }
    
    /*
    private void sendEmail() {
    	System.out.println("Putting in a default email...");
    	sendEmail("interest.finder.for.ukg.members@gmail.com");
    }
    */

    private void sendEmail(String internThatFilledInTheSurvey, String inEmails) {
    	try {
    		SimpleMailMessage msg = new SimpleMailMessage();
        
    		msg.setTo(internThatFilledInTheSurvey);
    		msg.setSubject("Matches were found!");
    		msg.setText("Hello! Here is the list of emails that most similiar to yours: " + inEmails); 		   		
    		javaMailSender.send(msg);
    	}
    	catch(MailAuthenticationException e) {
    		System.out.println("Authentication was wrong! " + e.toString());
    	}
    	catch(IllegalStateException i) {
    		System.out.println("We reached a weird illegal state: " + i.toString());
    	}
    	catch(Exception x) {
    		System.out.println("Some other exception was caught: " + x.toString());
    	}
    }
    
    public void pie() {
    	System.out.println("Pie!");
    }
	

	//Copy and pasted from Spring.io guide
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			ArrayList<String> internInfo = generateCSV();
			
			//0 is the intern's email, 1 is the emails that will be sent to them
			sendEmail(internInfo.get(0), internInfo.get(1));
		};
	}
	
	
}
