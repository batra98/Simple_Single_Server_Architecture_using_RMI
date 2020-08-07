# Single Server Architecture in Java.

Using RMI(Remote Method Invocation) in Java to implement a simple single server architecture with support for multiple clients.

The server will have functions to store the graph,add edges to graph and get the minimum spanning tree of the graph.
 
## :running: Run
**Compile** : 
```bash
javac *.java
```

**Start Server**
```bash
java Server <port>

```

**Start Client**
```bash
java Client <server-ip>  <server-port>  
```

## :file_folder: Files 
──> README.md       // Instructions

──> Server.java     // Main Server 

──> GraphMst.java   // contains all the classes and functions
  ──> Edge class
  ──> Graph class
  ──> add_edge function
  ──> get_mst function
  ──> add_graph function

──> Mst.java  // Interface for the GraphMst class

──> Client.java       // Client server


## Commands and their usage:

1. `add_edge`:Adds an edge between 2 nodes. 

   ```
   add_edge graph_name <u> <v>
   ```

2. `get_mst`: Find the mst of the graph. 

   ```
   get_mst graph_name
   ```

3. `add_graph`: Add a new graph. 
   
   ```
   add_graph graph_name <n>
   ```

[![asciicast](https://asciinema.org/a/fUwf6JSwkV1ctpd8xmXon2QNI.svg)](https://asciinema.org/a/fUwf6JSwkV1ctpd8xmXon2QNI)
_____

Feel free to contribute :heart: