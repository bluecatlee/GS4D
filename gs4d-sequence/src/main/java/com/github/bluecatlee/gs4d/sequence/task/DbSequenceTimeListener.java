package com.github.bluecatlee.gs4d.sequence.task;

import com.github.bluecatlee.gs4d.sequence.service.SequenceTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 检测数据库存储的sequenceTime是否正确
 */
@Component
public class DbSequenceTimeListener {

    @Value("#{settings['emailAddress']}")
    public String emailAddress;

    @Autowired
    private SequenceTimeService sequenceTimeService;

//    @Autowired
//    private MailSendService mailSendService;

    protected static Logger logger = LoggerFactory.getLogger(DbSequenceTimeListener.class);

    public DbSequenceTimeListener() {
    }

    public void listenSequenceTime() {
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String currentTime = format.format(new Date());
//            String sequenceTime = this.sequenceTimeService.getTime();
//            if (Integer.valueOf(sequenceTime.replaceAll("-", "")) < Integer.valueOf(currentTime.replaceAll("-", ""))) {
//                EmailSendRequest var4 = new EmailSendRequest();
//                var4.setDataSign(0L);
//                var4.setTenantNumId(1L);
//                var4.setEmailModel(1L);
//                var4.setEmailSubject("platform_sequence_time 序列号时间表时间监控异常!");
//                var4.setEmailSenderType(1L);
//                var4.setEmailRecipients(this.emailAddress);
//                ArrayList var5 = new ArrayList();
//                EmailSendDetail var6 = new EmailSendDetail();
//                var6.setRequestMehtodName("listenSequenceTime");
//                var6.setRequestParam("platform_sequence_time 序列号时间表时间监控异常!");
//                InetAddress var7 = InetAddress.getLocalHost();
//                String var8 = var7.getHostName();
//                String var9 = var7.getHostAddress();
//                var6.setResponseFunllBody("platform_sequence_time 序列号时间表时间监控异常!主机名为:" + var8 + ",IP地址为:" + var9);
//                var6.setSystemName("sequence");
//                var5.add(var6);
//                var4.setEmailDetail(var5);
//                var4.setTenantNumId(1L);
//                var4.setDataSign(0L);
//                this.mailSendService.sendEmail(var4);
//                logger.info("邮件发送成功！");
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }

    }
}

