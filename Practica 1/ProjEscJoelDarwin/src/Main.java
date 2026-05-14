import controller.Menus.MainMenu;
import model.dto.api.ApiEscolaDto;
import model.entity.*;
import java.util.*;

import api.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.sync.EscaladorSyncService;
import service.sync.EscolaSyncService;
import service.sync.SectorSyncService;
import service.sync.ViaSyncService;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
         MainMenu menu = new MainMenu();
         menu.iniciar();
    }
}