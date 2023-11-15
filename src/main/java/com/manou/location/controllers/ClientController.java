package com.manou.location.controllers;

import com.manou.location.models.Client;
import com.manou.location.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

    /*@GetMapping("/clients")
    public  String getClients(){
        return "pages/client";
    }*/

    @Autowired
    private ClientService clientService;

    /**
     * Create - Add a new employee
     * @param client An object employee
     * @return The employee object saved
     */
    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }


    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable("id") int id) {
        Optional<Client> client = clientService.getClient(id);
        if(client.isPresent()) {
            return client.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/clients")
    public Iterable<Client> getClients() {
        return clientService.getClients();
    }

    /**
     * Update - Update an existing employee
     * @param id - The id of the employee to update
     * @param client - The employee object updated
     * @return
     */
    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable("id") int id, @RequestBody Client client) {
        Optional<Client> e = clientService.getClient(id);
        if(e.isPresent()) {
            Client currentClient = e.get();

            Integer num_cin = client.getNum_cin();
            if(num_cin != null) {
                currentClient.setNum_cin(num_cin);
            }
            String nom = client.getNom();
            if(nom != null) {
                currentClient.setNom(nom);;
            }
            String prenom = client.getPrenom();
            if(prenom != null) {
                currentClient.setPrenom(prenom);
            }
            String adresse = client.getAdresse();
            if(adresse != null) {
                currentClient.setAdresse(adresse);;
            }
            String email = client.getEmail();
            if(email != null) {
                currentClient.setEmail(email);;
            }

            clientService.saveClient(currentClient);
            return currentClient;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") int id) {
        clientService.deleteClient(id);
    }

}
