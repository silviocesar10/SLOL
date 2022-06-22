/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifes.ci.si.les.slol.service;

import edu.ifes.ci.si.les.slol.model.Livro;
import edu.ifes.ci.si.les.slol.resources.exceptions.StandardError;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author silvio
 */
public class LivroService {
    private final String URL = "http://localhost:8080/livros/";
    //private final String URL = "https://slol-backend-spring-postgres.herokuapp.com/livros/";
    
    private final Client client = ClientBuilder.newClient();

    public Livro find(Integer id) {
        try {
            WebTarget target = client.target(URL + id);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            Livro livro = mapper.readValue(json, Livro.class);
            return livro;
        } catch (IOException ex) {
            Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Livro> findAll() {
        try {
            WebTarget target = client.target(URL);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Livro>> mapType = new TypeReference<List<Livro>>() {
            };
            List<Livro> lista = mapper.readValue(json, mapType);
            return lista;
        } catch (IOException ex) {
            Logger.getLogger(LivroService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String insert(Livro livro) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(livro);
            Response response = target.request().post(Entity.entity(json, "application/json;charset=UTF-8"));
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                String stringError = response.readEntity(String.class);
                StandardError standardError = mapper.readValue(stringError, StandardError.class);
                return standardError.getMessage();
            }
        } catch (IOException ex) {
            Logger.getLogger(EmprestimoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String update(Livro livro) {
        try {
            WebTarget target = client.target(URL+livro.getId());
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(livro);
            Response response = target.request().put(Entity.entity(json, "application/json;charset=UTF-8"));
            if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                String stringError = response.readEntity(String.class);
                StandardError standardError = mapper.readValue(stringError, StandardError.class);
                return standardError.getMessage();
            }
        } catch (IOException ex) {
            Logger.getLogger(EmprestimoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String delete(Integer id) {
        try {
            WebTarget target = client.target(URL + id);
            ObjectMapper mapper = new ObjectMapper();
            Response response = target.request().delete();
            if (response.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
                String stringError = response.readEntity(String.class);
                StandardError standardError = mapper.readValue(stringError, StandardError.class);
                return standardError.getMessage();
            }
        } catch (IOException ex) {
            Logger.getLogger(EmprestimoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
