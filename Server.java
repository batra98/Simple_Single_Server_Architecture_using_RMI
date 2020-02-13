import java.rmi.Naming;

public class Server
{
	// public Server(int port)
	// {
	// 	try
	// 	{
	// 		Mst c = new GraphMst();

	// 		java.rmi.registry.LocateRegistry.createRegistry(port);

	// 		Naming.rebind("rmi://localhost:"+port+"/Mst",c);
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		System.out.println("Err "+e);
	// 	}
	// }

	public static void main(String[] args)
	{
		try
		{
			if(args.length != 1)
			{
				System.out.println("Error: Specify port number");
				System.exit(0);
			}

			Integer port = Integer.parseInt(args[0]);

			Mst c = new GraphMst();

			java.rmi.registry.LocateRegistry.createRegistry(port);

			Naming.rebind("rmi://localhost:"+port+"/Mst",c);
			// new Server(port);
		}
		catch(Exception e)
		{
			System.out.println("Err "+e);
		}
	}
}