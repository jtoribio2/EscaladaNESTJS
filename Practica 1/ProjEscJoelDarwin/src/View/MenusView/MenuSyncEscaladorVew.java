package View.MenusView;

public class MenuSyncEscaladorVew {
    private static final String MENU_SYNC_ESCALADORS = """

        ╔══════════════════════════════════════════════╗
        ║                                              ║
        ║            SYNC ESCALADORS                   ║
        ║                                              ║
        ╠══════════════════════════════════════════════╣
        ║                                              ║
        ║   1. Sincronitzar tots                       ║
        ║   2. Sincronitzar per ID                     ║
        ║                                              ║
        ║   0. Tornar                                  ║
        ║                                              ║
        ╚══════════════════════════════════════════════╝

        Selecciona una opció:
        """;

    public static void mostrarMenu() {
        System.out.println(MENU_SYNC_ESCALADORS);
    }
}
