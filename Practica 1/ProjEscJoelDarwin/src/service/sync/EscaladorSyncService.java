package service.sync;

import api.ApiClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import config.ApiConfig;
import config.AppConfig;

import model.dto.api.ApiEscaladorDto;
import model.entity.Escalador;

import service.EscaladorService;

public class EscaladorSyncService {

    private final ApiClient apiClient;

    private final ObjectMapper mapper;

    private final EscaladorService escaladorService;

    public EscaladorSyncService() {

        this.apiClient = new ApiClient();

        this.mapper = new ObjectMapper();

        this.escaladorService =
                AppConfig.getEscaladorService();
    }

    public void syncEscaladors() {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/escaladors"
            );

            ApiEscaladorDto[] escaladorsDto =
                    mapper.readValue(
                            json,
                            ApiEscaladorDto[].class
                    );

            for (ApiEscaladorDto dto : escaladorsDto) {

                Escalador escalador =
                        convertirDtoAEntity(dto);

                escaladorService
                        .guardarOSincronizarEscalador(
                                escalador
                        );
            }

            System.out.println(
                    "Escaladors sincronitzats correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public void syncEscaladorById(int id) {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/escaladors" + id
            );

            ApiEscaladorDto dto =
                    mapper.readValue(
                            json,
                            ApiEscaladorDto.class
                    );

            Escalador escalador =
                    convertirDtoAEntity(dto);

            escaladorService
                    .guardarOSincronizarEscalador(
                            escalador
                    );

            System.out.println(
                    "Escalador sincronitzat correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    private Escalador convertirDtoAEntity(
            ApiEscaladorDto dto
    ) {

        Escalador escalador = new Escalador();

        escalador.setId_escalador(
                dto.getIdEscalador()
        );

        escalador.setDni(
                dto.getDni()
        );

        escalador.setNom(
                dto.getNom()
        );

        escalador.setEdat(
                dto.getEdat()
        );

        escalador.setEstil(
                dto.getEstil()
        );

        return escalador;
    }
}