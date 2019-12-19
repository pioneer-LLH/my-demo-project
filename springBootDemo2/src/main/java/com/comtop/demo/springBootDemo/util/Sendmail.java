package com.comtop.demo.springBootDemo.util;


import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import java.util.Date;

//发送邮件（163）来源：https://blog.csdn.net/weixin_44820069/article/details/94037065，https://www.cnblogs.com/loveflycforever/p/5862389.html
public class Sendmail {
    //不带附件的邮箱发送
    public static void send() {
        try {
            //简单邮箱的核心对象
            SimpleEmail simpleEmail = new SimpleEmail();
            //设置发送邮箱的服务信息
            simpleEmail.setSmtpPort(25);//网易邮箱端口号，按照所用的邮箱灵活更换对应端口
            simpleEmail.setHostName("smtp.163.com");//服务器，例：smtp.qq.com
            //设置发件人邮箱的安全验证:用户名、”授权码“
            simpleEmail.setAuthentication("guojiadashi@163.com", "game12345");
            simpleEmail.setFrom("guojiadashi@163.com");//发件人邮箱
            simpleEmail.addTo("1260991448@qq.com");//收件人邮箱
            simpleEmail.addCc("guojiadashi@163.com");//抄送:报错554时，排除低俗信息，抄送自己可解决
            //邮件内容
            simpleEmail.setSubject("我为什么要借你钱");//标题
            simpleEmail.setMsg("hello world");//正文
            simpleEmail.setCharset("utf-8");//编码格式
            simpleEmail.setSentDate(new Date());//发送时间

            //发送
            simpleEmail.send();
            System.out.println("成功");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    //带附件的邮箱发送
    public static void sendAccessory(){
        //
        try {
            MultiPartEmail multiPartEmail = new MultiPartEmail();
            multiPartEmail.setSmtpPort(25);//端口
            multiPartEmail.setHostName("smtp.163.com");//服务器
            //发件人验证：用户名，授权码
            multiPartEmail.setAuthentication("guojiadashi@163.com", "game12345");
            multiPartEmail.setFrom("guojiadashi@163.com");//发件人邮箱
            multiPartEmail.addTo(new String[]{"1260991448@qq.com","1363273668@qq.com"});//收件人邮箱
            multiPartEmail.addCc("guojiadashi@163.com");//抄送邮箱
            //邮件信箱
            multiPartEmail.setSubject("测试！带附件的邮件的多人发送！");//标题
            multiPartEmail.setMsg("测试测试测试测试。。。。。。。。。。。。。。。");//正文
            multiPartEmail.setCharset("utf-8");//字符集

            //设置添加附件
            EmailAttachment emailAttachment = new EmailAttachment();
            //设置文件地址
            emailAttachment.setPath("D:\\test.txt");//文件所在磁盘位置及文件名
            //设置格式
            emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
            emailAttachment.setName("test.txt");//邮箱显示文件名



            //加载到邮件中,可添加多个emailAttachment但前提是对象不同
            multiPartEmail.attach(emailAttachment);
            //发送时间
            multiPartEmail.setSentDate(new Date());
            //发送
            multiPartEmail.send();

            System.out.println("成功");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
         Sendmail.send();
    }
}



