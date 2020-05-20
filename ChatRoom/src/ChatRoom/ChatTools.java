package ChatRoom;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatTools {
    private static ArrayList<ServerThread> stList = new ArrayList<ServerThread>(){};
    private ChatTools(){
    }

    public static void addClient(ServerThread st)throws Exception {
        stList.add(st);
        castMsg(st.getOwnerUser(),"：我上线了！");
    }

    public static void castMsg(UserInfo sender,String msg)throws Exception{
        msg = sender.getName() + "说：" + msg;
        for(int i=0;i<stList.size();i++){
            ServerThread st = stList.get(i);
            st.sendMsg2Me(msg);
        }
    }
}
