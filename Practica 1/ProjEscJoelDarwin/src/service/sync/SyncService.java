package service.sync;
import api.ApiClient;
import config.ApiConfig;
import model.dto.api.ApiVersionDTO;
public class SyncService {

    private final EscolaSyncService escolaSyncService;
    private final SectorSyncService sectorSyncService;
    private final ViaSyncService viaSyncService;
    private final EscaladorSyncService escaladorSyncService;
    private final ApiClient apiClient = new ApiClient();

    public SyncService() {

        escolaSyncService = new EscolaSyncService();
        sectorSyncService = new SectorSyncService();
        viaSyncService = new ViaSyncService();
        escaladorSyncService = new EscaladorSyncService();
    }

    public void syncTot() {

        syncTerreny();
        syncTotsEscaladors();
    }

    public void syncTerreny() {

        escolaSyncService.syncEscoles();
        sectorSyncService.syncSectors();
        viaSyncService.syncVies();
    }

    public void syncTotsEscaladors() {

        escaladorSyncService.syncEscaladors();
    }

    public void syncEscaladorPerId(int id) {

        escaladorSyncService.syncEscaladorById(id);
    }

    public boolean validarVersio() {

        try {

            ApiVersionDTO versionDTO = apiClient.obtenirVersio();

            return versionDTO.getVersion()
                    .equals(ApiConfig.API_VERSION);

        } catch (Exception e) {

            System.out.println("Error comprovant la versió de la API");

            return false;
        }
    }
}