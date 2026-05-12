import controller.Menus.MainMenu;
import model.dto.api.ApiEscolaDto;
import model.entity.*;
import java.util.*;

import api.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ApiClient apiClient = new ApiClient();

        try {

            String json = apiClient.get(
                    "http://localhost:3000/escoles"
            );

            ObjectMapper mapper = new ObjectMapper();

            ApiEscolaDto[] vias = mapper.readValue(
                    json,
                    ApiEscolaDto[].class
            );

            for (ApiEscolaDto via : vias) {
                System.out.println(via.getNom());
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        // MainMenu menu = new MainMenu();
        // menu.iniciar();
    }
}