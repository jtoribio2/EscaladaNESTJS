package service.sync;

import api.ApiClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import config.ApiConfig;
import config.AppConfig;

import model.dto.api.ApiEscolaDto;
import model.entity.Escola;

import service.EscolaService;

public class EscolaSyncService {

    private final ApiClient apiClient;

    private final ObjectMapper mapper;

    private final EscolaService escolaService;

    public EscolaSyncService() {

        this.apiClient = new ApiClient();

        this.mapper = new ObjectMapper();

        this.escolaService =
                AppConfig.getEscolaService();
    }
    /**
     * Hace una sicnronizacion total de todas las escolas que devuelve el endpoint esten o no repetidos en nuestra base de datos
     */
    public void syncEscoles() {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/escoles"
            );

            ApiEscolaDto[] escolesDto =
                    mapper.readValue(
                            json,
                            ApiEscolaDto[].class
                    );

            for (ApiEscolaDto dto : escolesDto) {

                Escola escola =
                        convertirDtoAEntity(dto);

                escolaService
                        .guardarOSincronizarEscola(
                                escola
                        );
            }

            System.out.println(
                    "Escoles sincronitzades correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }
    /**
     * sincoriniza en la base de datos una escola a traves de su id perteneciente en el endpoint
     * @param id
     */
    public void syncEscolaById(int id) {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/escoles/" + id
            );

            ApiEscolaDto dto =
                    mapper.readValue(
                            json,
                            ApiEscolaDto.class
                    );

            Escola escola =
                    convertirDtoAEntity(dto);

            escolaService
                    .guardarOSincronizarEscola(
                            escola
                    );

            System.out.println(
                    "Escola sincronitzada correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    private Escola convertirDtoAEntity(
            ApiEscolaDto dto
    ) {

        Escola escola = new Escola();

        escola.setId_escola(
                dto.getIdEscola()
        );

        escola.setNom(
                dto.getNom()
        );

        escola.setLloc(
                dto.getLloc()
        );

        escola.setAproximacio(
                dto.getAproximacio()
        );

        escola.setPopularitat(
                dto.getPopularitat()
        );

        return escola;
    }
}