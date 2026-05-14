package service.sync;

public class SyncService {

    private final EscolaSyncService escolaSyncService;
    private final SectorSyncService sectorSyncService;
    private final ViaSyncService viaSyncService;
    private final EscaladorSyncService escaladorSyncService;

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
}