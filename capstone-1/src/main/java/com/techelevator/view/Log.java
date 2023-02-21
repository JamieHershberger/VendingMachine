package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    static PrintWriter write;
    //initialized LocalDateTime and formatted with DateTimeFormatter to keep record of a date to the logs
    static LocalDateTime time = LocalDateTime.now();
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss a");
    static String formattedTime = time.format(format);
    private String file = "log.txt";
    File newFile = new File(file);

    //Only one method, log, which writes the log
    public static void log(String message) {
//if statement says if null, create Printwriter, write to logs

        if (write == null) {
            try {
                write = new PrintWriter((new FileOutputStream(new File("log.txt"), true)));

            } catch (Exception ex) {
                System.out.println(message);
            }
        }
        //displays the formatted time and the contents of log method
        write.println("\n" + formattedTime + "\n" + message);
        write.flush();

    }
}
