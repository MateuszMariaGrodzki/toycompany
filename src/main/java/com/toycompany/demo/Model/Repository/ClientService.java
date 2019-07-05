package com.toycompany.demo.Model.Repository;

import com.toycompany.demo.Model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
}
