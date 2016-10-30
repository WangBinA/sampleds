package sampleds.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CommandLine {
  private static final Map<String, String> commandMap = new HashMap<String,String>();

  static {
    commandMap.put("listfiles", "node");
    commandMap.put("kill", "node");
  }
  
  public static void main(String[] args) throws IOException {
    
    
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    String line;
    while ((line = br.readLine()) != null) {
        executeLine(line);
    }

  }
  
  private static void executeLine(String cmdStr) {
    System.out.println(cmdStr);
    if (cmdStr.equals("listfiles node1")) {
      //@TODO
      System.out.println("Node\tfile\tsize\tprocess\ttime");
      System.out.println("node1\taaa.txt\t6666\t100%\t5s ago");
    } else if (cmdStr.equals("kill node1")) {
      System.out.println("node1 is shutting down...");
      // no more new connections
      System.out.println("node1 is off.");
    } else {
      printUsage();
    }
  }
  
  private static void printUsage() {
    System.err.println("ZooKeeper -server host:port cmd args");
    for (String cmd : commandMap.keySet()) {
        System.err.println("\t"+cmd+ " " + commandMap.get(cmd));
  }
}
}
