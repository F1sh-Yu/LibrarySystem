package ChatRoom;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args)throws Exception {
        ChatServer server = new ChatServer();
        server.setUpServer(9000);
    }

    private void setUpServer(int port)throws Exception{
        ServerSocket server = new ServerSocket(port);
        ExecutePool pool = new ExecutePool(50,10000);
        while(true){
            Socket socket = server.accept();
            System.out.println("进入了一个客户机连接："+socket.getRemoteSocketAddress().toString());
            pool.execute(new ServerThread(socket));
        }
    }
}
