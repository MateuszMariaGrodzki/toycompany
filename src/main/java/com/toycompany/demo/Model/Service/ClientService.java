package com.toycompany.demo.Model.Service;

import com.toycompany.demo.Model.Client;
import com.toycompany.demo.Model.Repository.ClientRepository;
import com.toycompany.demo.Model.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<String> dateFromDatabase(){
        Iterable<Client> clients = clientRepository.findAll();
        List<String> dates = new ArrayList<>();
        for (Client client : clients){
            dates.add(client.getDate());
        }
        return dates;
    }

    public boolean isDateInDatabase(String date){
        List<String> dates = dateFromDatabase();
        for(String string : dates ) {
            if(string.equals(date)) {
                return true;
            }
        }
        return false;
    }

    public String getPasswordByEmail(String email){
        Iterable<Client> clients = clientRepository.findAll();
        for(Client client : clients) {
            if(client.getEmail().equals(email)){
                return client.getPassword();
            }
        }
        return "";
    }

    public boolean isEmailInDatabase(String email) {
        Iterable<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            if(client.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getAllNames(){
        List<String> result = new ArrayList<>();
        Iterable<Client> clients = clientRepository.findAll();
        for (Client client : clients){
            result.add(client.getName());
        }
        return result;
    }

    public Client getClientByName(String name){
        Iterable<Client> clients = clientRepository.findAll();
        for(Client client : clients) {
            if(client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }

    public List<Toy> getToysByClientName(String name){
        Client client = getClientByName(name);
         return client.getReservedToys();
    }

    public String getNameByEmail(String email) {
        Iterable<Client> clients = clientRepository.findAll();
        for(Client client : clients) {
            if(client.getEmail().equals(email)){
                return client.getName();
            }
        }
        return null;
    }

    public List<String> getAllEmails(){
        Iterable<Client> clients = clientRepository.findAll();
        List<String> result = new ArrayList<>();
        for (Client client : clients) {
            result.add(client.getEmail());
        }
        return result;
    }

    public Client getClientByEmail(String email) {
        Iterable<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

    public List<Toy> getToysByClientEmail(String email){
        Client client = getClientByEmail(email);
        return client.getReservedToys();
    }

    public Client getClientByDate(String date) {
        Iterable<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            if (client.getDate().equals(date)) {
                return client;
            }
        }
        return null;
    }

    public List<Toy> getReservedToysByDate(String date) {
        Client client = getClientByDate(date);
        return client.getReservedToys();
    }
    

    public void deleteClientByName(String name){
        Client client = getClientByName(name);
        clientRepository.delete(client);
    }

}
