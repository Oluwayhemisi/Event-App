package africa.semicolon.mogbo.services;


import africa.semicolon.mogbo.data.models.Party;
import africa.semicolon.mogbo.data.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    private PartyRepository partyRepository;

    @Override
    public Party saveParty(Party party){
        return partyRepository.save(party);
    }
}
