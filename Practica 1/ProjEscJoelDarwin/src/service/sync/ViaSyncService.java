package service.sync;

import api.ApiClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import config.ApiConfig;
import config.AppConfig;

import model.dto.api.ApiViaDto;

import model.entity.Via;

import service.ViaService;

public class ViaSyncService {

    private final ApiClient apiClient;

    private final ObjectMapper mapper;

    private final ViaService viaService;

    public ViaSyncService() {

        this.apiClient = new ApiClient();

        this.mapper = new ObjectMapper();

        this.viaService =
                AppConfig.getViaService();
    }

    public void syncVies() {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/vies"
            );

            ApiViaDto[] viesDto =
                    mapper.readValue(
                            json,
                            ApiViaDto[].class
                    );

            for (ApiViaDto dto : viesDto) {

                Via via =
                        convertirDtoAEntity(dto);

                viaService
                        .guardarOSincronizarVia(
                                via
                        );
            }

            System.out.println(
                    "Vies sincronitzades correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public void syncViaById(int id) {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/vies" + id
            );

            ApiViaDto dto =
                    mapper.readValue(
                            json,
                            ApiViaDto.class
                    );

            Via via =
                    convertirDtoAEntity(dto);

            viaService
                    .guardarOSincronizarVia(
                            via
                    );

            System.out.println(
                    "Via sincronitzada correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    private Via convertirDtoAEntity(
            ApiViaDto dto
    ) {

        Via via = new Via();

        via.setId_via(
                dto.getId_via()
        );

        via.setNom(
                dto.getNom()
        );

        via.setLlargada(
                dto.getLlargada()
        );

        via.setDificultat(
                dto.getDificultat()
        );

        via.setOrientacio(
                dto.getOrientacio()
        );

        via.setAncoratge(
                dto.getAncoratge()
        );

        via.setTroca(
                dto.getTroca()
        );

        /*
            FK Sector
         */
        via.setId_sector(
                dto.getSector()
                        .getIdSector()
        );

        /*
            FK TipusVia
         */
        via.setId_tipus_via(
                dto.getTipusVia()
                        .getIdTipusVia()
        );

        return via;
    }
}