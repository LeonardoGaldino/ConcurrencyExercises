package q2_2017_2;

import java.util.List;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) {
		Account ac = new Account();
		List<Client> clients = new LinkedList<Client>();
		int numClients = 6;
		for(int i = 0 ; i < numClients ; ++i)
			clients.add(new Client(ac, i+1));
		
		for(Client client : clients)
			(new Thread(client)).start();
		
	}

}
