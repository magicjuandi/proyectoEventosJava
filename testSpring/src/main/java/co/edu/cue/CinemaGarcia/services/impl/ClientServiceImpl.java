package co.edu.cue.CinemaGarcia.services.impl;

import co.edu.cue.CinemaGarcia.mapping.dtos.ClientDto;
import co.edu.cue.CinemaGarcia.services.Service;

import java.util.List;

public class ClientServiceImpl implements Service<ClientDto> {
    @Override
    public List<ClientDto> list() {
        System.out.println("Here is the list");
        return null;
    }

    @Override
    public ClientDto byId(Long id) {
        System.out.println("Here is byId");
        return null;
    }

    @Override
    public void save(ClientDto clientDto) {
        System.out.println("Here is to save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("Here is to delete");
    }
}
