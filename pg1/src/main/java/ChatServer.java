import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;           
import javax.websocket.OnClose;            
import javax.websocket.OnMessage;          
import javax.websocket.OnOpen;               

import java.util.logging.Logger;              
import java.util.*;                           
import java.io.IOException;                   

@ServerEndpoint("/chat")
public class ChatServer{
    private static List<Session> sessions = new ArrayList<Session>();;
    private static final Logger logger = Logger.getLogger(ChatServer.class.getName());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        logger.info("Opening connection with session " + session.getId());
    }

    @OnClose
    public void onClose(Session session) {
        logger.info("Closing connection with session " + session.getId());
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("Got message `" + message + "` from session " + session.getId());
        for (Session s : sessions) {
            if (!Objects.equals(s, session)) {
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    logger.warning("Got IOException. Closing session " + s.getId());
                    sessions.remove(s);
                }
            }
        }
    }
}
