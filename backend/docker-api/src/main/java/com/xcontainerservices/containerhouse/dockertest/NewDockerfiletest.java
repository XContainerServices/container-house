package com.xcontainerservices.containerhouse.dockertest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xcontainerservices.containerhouse.dockerapi.templates.CreateTemplate;

public class NewDockerfiletest {

    public static void main(String[] args) throws IOException, InterruptedException {
        CreateTemplate ct = new CreateTemplate();
        ct.createTemplateFromDockerFile("/home/hackintosh/Dockerfile/standard/df", "banjara");
    }

}
