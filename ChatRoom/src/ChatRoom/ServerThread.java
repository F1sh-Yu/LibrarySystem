package ChatRoom;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;

public class ServerThread extends Thread {
    private Socket client;
    private OutputStream ous;
    private UserInfo user;

    public ServerThread(Socket socket){
        this.client = socket;
    }

    public void run() {
        try {
            processSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserInfo getOwnerUser(){
        return user;
    }

    public void sendMsg2Me(String msg)throws Exception{
        msg += "\r\n";
        ous.write(msg.getBytes());
        ous.flush();

    }

    private void processSocket()throws Exception {
        InputStream ins = client.getInputStream();
        ous = client.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        //用BufferedReader类可以读取整行
        int flag = 1;
        String userName;
        String pwd;
        user = new UserInfo();
        while(flag==1)
        {
        sendMsg2Me("注册请输入1，登陆请输入2");
        flag = br.readLine().charAt(0)-'0';
        System.out.println(flag);
        sendMsg2Me("请输入用户名：");
        userName = br.readLine();
        sendMsg2Me("请输入密码");
        pwd = br.readLine();
        user.setName(userName);
        user.setPassword(pwd);
        if(flag==1 ){
            if(DaoTools.register(user)) sendMsg2Me("注册成功!");
            else sendMsg2Me("注册失败，请重试！");
        }
        }
        //检查用户是否存在
        boolean loginState = DaoTools.checkLogin(user);
        if (!loginState) {
            sendMsg2Me("登陆错误！");
            this.closeMe();
            return;
        }
        ChatTools.addClient(this);
        String input = br.readLine();
        while (!input.equals("bye")) {
            System.out.println("服务器读到的是:" + input);
            ChatTools.castMsg(this.user, input);
            input = br.readLine();
        }
        ChatTools.castMsg(this.user, "bye");
        this.closeMe();
    }

    private void closeMe() throws Exception {
        ous.close();
        client.close();
    }
}
