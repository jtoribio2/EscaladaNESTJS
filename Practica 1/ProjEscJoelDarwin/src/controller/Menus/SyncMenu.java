package controller.Menus;

import View.MenusView.MenuSyncEscaladorVew;
import View.MenusView.MenuSyncView;
import service.sync.SyncService;

import java.util.Scanner;

public class SyncMenu {

    private final Scanner sc = new Scanner(System.in);

    private final SyncService syncService = new SyncService();

    public void iniciar() {

        if (!syncService.validarVersio()) {

            System.out.println("La versió de la API no és compatible");
            return;
        }

        int opcio;

        do {

            MenuSyncView.mostrarMenu();

            while (!sc.hasNextInt()) {

                System.out.println("Introdueix un número vàlid");
                sc.nextLine();
            }

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:

                    syncService.syncTot();

                    System.out.println("Sincronització completada");
                    break;

                case 2:

                    syncService.syncTerreny();

                    System.out.println("Terreny sincronitzat");
                    break;

                case 3:

                    menuEscaladors();
                    break;

                case 0:

                    System.out.println("Tornant...");
                    break;

                default:

                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }

    private void menuEscaladors() {

        int opcio;

        do {

            MenuSyncEscaladorVew.mostrarMenu();

            while (!sc.hasNextInt()) {

                System.out.println("Introdueix un número vàlid");
                sc.nextLine();
            }

            opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio) {

                case 1:

                    syncService.syncTotsEscaladors();

                    System.out.println("Escaladors sincronitzats");
                    break;

                case 2:

                    System.out.print("Introdueix ID escalador: ");

                    int id = sc.nextInt();
                    sc.nextLine();

                    syncService.syncEscaladorPerId(id);

                    System.out.println("Escalador sincronitzat");
                    break;

                case 0:

                    System.out.println("Tornant...");
                    break;

                default:

                    System.out.println("Opció incorrecta");
            }

        } while (opcio != 0);
    }
}