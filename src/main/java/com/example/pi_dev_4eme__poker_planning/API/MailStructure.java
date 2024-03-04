package com.example.pi_dev_4eme__poker_planning.API;

import com.example.pi_dev_4eme__poker_planning.Services.SessionServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class MailStructure {
    private String subject ="Rejoindre Session ";
    private String message ="This is mail send ";
    private Integer idSession;
    private String linkSession;


}
