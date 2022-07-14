package africa.semicolon.mogbo.data.services;

import africa.semicolon.mogbo.data.models.Party;
import africa.semicolon.mogbo.data.repositories.PartyRepository;
import africa.semicolon.mogbo.services.PartyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PartyServiceImplTest {

    @Autowired
    private PartyService partyServiceImpl;

    @Autowired
    private PartyRepository partyRepository;


    @Test
    public void addNewPartyTest(){
        Party party = new Party();
        Party savedParty = partyServiceImpl.saveParty(party);
        assertEquals(1,partyRepository.count());
    }
}