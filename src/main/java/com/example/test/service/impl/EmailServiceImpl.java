package com.example.test.service.impl;

import com.example.test.service.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {

    @Resource
    private JavaMailSender mailSender;


    @Value("${sendform.fromEmail}")
    private String fromEmail;

    static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Override
    public void sendHtmlMail(String receiveEmail, String subject, String emailContent) throws MessagingException {
        init(receiveEmail, subject, emailContent, mailSender, fromEmail);

    }

    @Async
    public void init(String receiveEmail, String subject, String emailContent, JavaMailSender mailSender,
                     String fromEmail) throws MessagingException {
        MimeMessage message= mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(fromEmail);
        helper.setTo(receiveEmail);
        helper.setSubject(subject);
        helper.setText(emailContent,true);
        //helper.addInline("qr",new FileSystemResource(filePath));
        mailSender.send(message);
    }

    @Override
    public void sendAttachmentsMail(String receiveEmail, String subject, String emailContent, List<String> filePathList) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        //带附件第二个参数true
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(receiveEmail);
        helper.setSubject(subject);
        helper.setText(emailContent, true);
        //添加附件资源
        for (String item : filePathList) {
            FileSystemResource file = new FileSystemResource(new File(item));
            String fileName = item.substring(item.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
        }
        //发送邮件
        mailSender.send(message);
    }

    /**
     *
     * @param receiveEmail 接收者
     * @param subject 主体
     * @param content 内容
     */
    @Override
    public void sendSimpleMail(String receiveEmail, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(receiveEmail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}
