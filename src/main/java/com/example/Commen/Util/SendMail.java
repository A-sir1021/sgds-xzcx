package com.example.Commen.Util;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

public class SendMail implements Runnable {
    private final String code;
    private final String email;
    private final JavaMailSender javaMailSender;
    private final int operation;
    public SendMail(String code, String email, JavaMailSender javaMailSender, int operation) {
        this.code = code;
        this.email = email;
        this.javaMailSender = javaMailSender;
        this.operation = operation;
    }
    @Override
    public void run() {
        javaMailSender.send((new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                System.out.println("开始发邮件...");
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setFrom(MyConstant.MAIL_FROM);
                mimeMessageHelper.setTo(email);
                mimeMessageHelper.setSubject("一封激活邮件");
                StringBuilder sb = new StringBuilder();
                sb.append("<html><head></head><body>");
                if (operation == 1) {
                    sb.append("<h3>明日新闻注册：</h3><a href=" + MyConstant.DOMAIN_NAME + "activate?code=");
                    sb.append(code);
                    sb.append(">点击激活</a></body>");
                } else {
                    sb.append("是否将您的密码修改为:");
                    sb.append(code, 0, 8);
                    sb.append("，<a href=" + MyConstant.DOMAIN_NAME + "tologin?code=" + code + ">");
                    sb.append("点击是</a></body>");
                }

                mimeMessageHelper.setText(sb.toString(), true);

                System.out.println("结束发邮件...");
            }
        }));


    }
}
