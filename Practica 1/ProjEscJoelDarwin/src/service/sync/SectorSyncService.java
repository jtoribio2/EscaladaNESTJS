package service.sync;

import api.ApiClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import config.ApiConfig;
import config.AppConfig;

import model.dto.api.ApiSectorDto;
import model.entity.Sector;

import service.SectorService;

public class SectorSyncService {

    private final ApiClient apiClient;

    private final ObjectMapper mapper;

    private final SectorService sectorService;

    public SectorSyncService() {

        this.apiClient = new ApiClient();

        this.mapper = new ObjectMapper();

        this.sectorService =
                AppConfig.getSectorService();
    }
    /**
     * Hace una sicnronizacion total de todos los sectores que devuelve el endpoint esten o no repetidos en nuestra base de datos
     */
    public void syncSectors() {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/sectors"
            );

            ApiSectorDto[] sectorsDto =
                    mapper.readValue(
                            json,
                            ApiSectorDto[].class
                    );

            for (ApiSectorDto dto : sectorsDto) {

                Sector sector =
                        convertirDtoAEntity(dto);

                sectorService
                        .guardarOSincronizarSector(
                                sector
                        );
            }

            System.out.println(
                    "Sectors sincronitzats correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }
    /**
     * sincoriniza en la base de datos un sector a traves de su id perteneciente en el endpoint
     * @param id
     */
    public void syncSectorById(int id) {

        try {

            String json = apiClient.get(
                    ApiConfig.BASE_URL + "/sectors/" + id
            );

            ApiSectorDto dto =
                    mapper.readValue(
                            json,
                            ApiSectorDto.class
                    );

            Sector sector =
                    convertirDtoAEntity(dto);

            sectorService
                    .guardarOSincronizarSector(
                            sector
                    );

            System.out.println(
                    "Sector sincronitzat correctament"
            );

        }
        catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    private Sector convertirDtoAEntity(
            ApiSectorDto dto
    ) {

        Sector sector = new Sector();

        sector.setId_sector(
                dto.getIdSector()
        );

        sector.setNom(
                dto.getNom()
        );

        sector.setLatitut(
                dto.getLatitut()
        );

        sector.setLongitut(
                dto.getLongitut()
        );

        sector.setAproximacio(
                dto.getAproximacio()
        );

        sector.setPopularitat(
                dto.getPopularitat()
        );

        /*
            FK Escola
         */
        sector.setId_escoles(
                dto.getEscola()
                        .getIdEscola()
        );

        return sector;
    }
}