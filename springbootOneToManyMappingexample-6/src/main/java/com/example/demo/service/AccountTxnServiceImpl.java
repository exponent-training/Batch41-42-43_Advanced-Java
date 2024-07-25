package com.example.demo.service;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.LongStream;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountData;
import com.example.demo.entity.TransactionData;
import com.example.demo.repo.AccountTxnRepository;

@Service
public class AccountTxnServiceImpl implements AccountTxnService {


	@Autowired
	private AccountTxnRepository accountTxnRepository;


	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public int createAccount(AccountData accountData) {
		// TODO Auto-generated method stub
		//Random 8 digit Number Generated . but in Sequence.
		//Ex : SBIN/00000001

		long count = accountTxnRepository.count();

		System.out.println("DB Count : " + count);

		if(count == 0) {
			count += 1; 
		}else if(count > 0) {
			count ++;
		}

		accountData.setAccountNumber("SBIN"+count);


		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String OpeningDate = dateFormat.format(date);

		accountData.setAccountOpeningDate(OpeningDate);
		accountData.setStatus(true);

		AccountData accountData2 = accountTxnRepository.save(accountData);

		if(accountData2 != null) {

			SimpleMailMessage message = new SimpleMailMessage();

			message.setTo("pramodkhandare0050@gmail.com","andhalekrushna101@gmail.com");

			message.setSubject("Thanks For Creating Account.");

			message.setText("Hi Team,  Thank you for Getting Our Service. Your Account Succeassfully Created.");


			javaMailSender.send(message);

		}

		return accountData2.getId();
	}

	@Override
	public AccountData getAccountData(int accnumber) {
		// TODO Auto-generated method stub

		String accNumber  = "SBIN"+accnumber;
		AccountData accountData = accountTxnRepository.findByAccountNumber(accNumber);
		return accountData;
	}

	@Override
	public void addTXTData(TransactionData txtData, int accno) {
		// TODO Auto-generated method stub
		AccountData accountData = getAccountData(accno);
		if(accountData != null) {

			//			Random random = new Random();
			//			LongStream  l = random.longs(0, 99999999);
			//			String l1 = l.toString();
			//			System.out.println(l1);

			txtData.setTxnId("12343212");

			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			String txtDate = dateFormat.format(date);

			txtData.setTxnDate(txtDate);

			//Another Account 
			if(addOtherAccountTxt(txtData.getCreditAmount())) {
				txtData.setTxnStatus("Success");
			}else {
				txtData.setTxnStatus("Failed");	
			}
			accountData.getTxtList().add(txtData);
			accountTxnRepository.save(accountData);
		}
	}


	private boolean addOtherAccountTxt(double amount) {

		AccountData accountData = new AccountData();
		accountData.setAccountNumber("12345678");

		if(accountData.getAccountNumber().equals("12345678")) {
			return true;
		}

		return false;

	}

	@Override
	public void sendMailAttachment() {
		// TODO Auto-generated method stub
		List<String> emailList = accountTxnRepository.findEmail();
		System.out.println(emailList.toString());
		String[] strArr= new String[emailList.size()];
		
		for(int i=0;i<emailList.size();i++) {
			strArr[i]=emailList.get(i);
		}
		
		Object[] arr= emailList.toArray();
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(strArr);
			
			helper.setText("Mail with Attachment.");
			
			helper.setSubject("Mail Sending");
			
			helper.addAttachment("Notification.pdf", new File("D:\\Documents\\Spring_Boot_send.pdf"));
			
			helper.addAttachment("Notification1.pdf", new File("D:\\Documents\\Spring_Boot_send.pdf"));
			
			javaMailSender.send(msg);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
