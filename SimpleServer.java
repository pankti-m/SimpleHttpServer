import com.sun.net.httpserver.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.HttpURLConnection;

class SimpleServer
{
	public static void main(String[] args) throws IOException
	{
		int backlog = 0;
		InetSocketAddress address = new InetSocketAddress(8000);
		HttpServer server = HttpServer.create(address, backlog);
		HttpHandler handler = new HttpHandler() {
			public void handle(HttpExchange exchg) throws IOException
			{
				String response = "Response from the server";
				exchg.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes().length);
				exchg.getResponseBody().write(response.getBytes());
				exchg.close();
			}
		};
		
		server.createContext("/HomePage", handler);
		server.start();
	}
}
	
/*
 * http://localhost:8000/HomePage
 */