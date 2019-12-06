package com.maxsoft.greporter.demo;

import com.maxsoft.greporter.Email;
import com.maxsoft.greporter.JsonReportReader;


public class EmailSender {

    public static void main(String[] args) {

        Email.send(JsonReportReader.getExecutionResults());
    }


}
