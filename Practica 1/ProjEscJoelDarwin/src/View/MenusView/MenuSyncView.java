package View.MenusView;

public class MenuSyncView {
    private static final String MENU_SYNC = """

        ╔══════════════════════════════════════════════╗
        ║                                              ║
        ║                MENU SYNC                     ║
        ║                                              ║
        ╠══════════════════════════════════════════════╣
        ║                                              ║
        ║   1. Sincronitzar tot                        ║
        ║   2. Sincronitzar terreny                    ║
        ║   3. Sincronitzar escaladors                 ║
        ║                                              ║
        ║   0. Tornar                                  ║
        ║                                              ║
        ╚══════════════════════════════════════════════╝

        Selecciona una opció:
        """;

    public static void mostrarMenu() {
        System.out.println(MENU_SYNC);
    }
}
