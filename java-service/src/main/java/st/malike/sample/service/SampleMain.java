/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st.malike.sample.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author malike_st
 */
@SpringBootApplication
@Controller
public class SampleMain {

  @Value("${go.service.url:http://localhost:8079}")
  private String GO_SERVICE_URL;

  @Value("${instance.name:One}")
  private String INSTANCE_NAME;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    SpringApplication.run(SampleMain.class, args);
  }

  @RequestMapping(value = {"/javaservice"}, method = RequestMethod.GET)
  @ResponseBody
  public String javaService() {
    return "{\"whoami\":\""+INSTANCE_NAME+" Java Service\"}";
  }

  @RequestMapping(value = {"/javaserviceroute"}, method = RequestMethod.GET)
  @ResponseBody
  public String javaServiceRoute() {
    return "{\"whoami\":\""+INSTANCE_NAME+" Java Route Service\"}";
  }

}
