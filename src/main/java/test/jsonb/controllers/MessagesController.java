package test.jsonb.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("messages")
public class MessagesController {

    @Value("${DB_URL}")
    private String databaseURl;

    @GetMapping(value = "/welcome")
    public ResponseEntity getWelcomeMessage(){
        log.info("Called the endpoint");
        return new ResponseEntity(databaseURl, HttpStatus.OK);
    }

}
