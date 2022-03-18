package org.chengbing.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SSHUtil {

    public static void SSHClient(String serverIp,String command, String usernameString,String password) throws IOException {
        try
        {
            Connection conn = new Connection(serverIp);
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(usernameString, password);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");
            ch.ethz.ssh2.Session sess = conn.openSession();
            sess.execCommand(command);
            InputStream stdout = new StreamGobbler(sess.getStdout());
            BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
            while (true)
            {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            // System.out.println("ExitCode: " + sess.getExitStatus());
            sess.close();
            conn.close();
        }
        catch (IOException e)
        {
            e.printStackTrace(System.err);

        }
    }
}
