package code.core.npc.rpc;
/**
 *   
 */
import code.core.npc.rpc.protocol.Protocol;
import code.core.npc.rpc.protocol.RPCProtocol;
import code.core.npc.rpc.server.RPCServerHandler;
import code.core.npc.rpc.server.ServerHandler;

/**
 * 
 */
public class ProtocolFactory {
	
//	private static final Log LOGGER = LogFactory.getLog(ProtocolFactory.class);
	
	private static Protocol[] protocolHandlers = new Protocol[5];
	
	private static ServerHandler[] serverHandlers = new ServerHandler[5];
	
	static{
		registerProtocol(RPCProtocol.TYPE, new RPCProtocol(), new RPCServerHandler());
	}
	
	public static void registerProtocol(int type,Protocol customProtocol,ServerHandler customServerHandler){
		if(type > protocolHandlers.length){
			Protocol[] newProtocolHandlers = new Protocol[type + 1];
			System.arraycopy(protocolHandlers, 0, newProtocolHandlers, 0, protocolHandlers.length);
			protocolHandlers = newProtocolHandlers;
			ServerHandler[] newServerHandlers = new ServerHandler[type + 1];
			System.arraycopy(serverHandlers, 0, newServerHandlers, 0, serverHandlers.length);
			serverHandlers = newServerHandlers;
		}
		protocolHandlers[type] = customProtocol;
		serverHandlers[type] = customServerHandler;
	}
	
	public static Protocol getProtocol(int type){
		return protocolHandlers[type];
	}
	
	public static ServerHandler getServerHandler(int type){
		return serverHandlers[type];
	}
	
}
