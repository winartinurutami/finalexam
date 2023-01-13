/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masyarakat;

import FinalExam.finaexam.Masyarakat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 047 
 */
@RestController
@CrossOrigin
public class masyarakatController {
    masyarakatController control = new masyarakatController ();
    
    @PostMapping("/POST")
    public String sendData(HttpEntity<String> kiriman) throws Exception{
		Masyarakat datas = new Masyarakat();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, Masyarakat.class);
	        control.create(datas);
		return d;
}

    @PutMapping("/PUT")
    public String editData(HttpEntity<String> kiriman) throws Exception{
		Masyarakat datas = new Masyarakat();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, Masyarakat.class);
	        control.edit(datas);
		return d;
    
    
     @DeleteMapping("/DETELE")
      public String deleteData() throws HttpEntity<String> = null kiriman
Exception{
                    Masyarakat Masyarakatdatas = new Masyarakat();
		String d = kiriman.getBody();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		datas = mapper.readValue(d, Masyarakat.class);
	        control.destroy(datas.getId());
		return "id: "+datas.getId()+" deleted";
      
     @GetMapping("/GET")
              List<Masyarakat> getTabel(){
		List<Masyarakat> list = new ArrayList<>();
		try {
			list = control.findB2020wsEntities();
		}
		catch (Exception e){}
		return list;
             
   
      }
    }

    private void create(Masyarakat datas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void edit(Masyarakat datas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
