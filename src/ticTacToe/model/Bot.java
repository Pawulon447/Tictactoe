package ticTacToe.model;

import ticTacToe.controller.Game;

import java.util.Random;

public class Bot {
    Game game1;

    private Board planszaKiK;

    private char znakGracza;

    public Bot() {

    }


    public void setZnakGracza(char znakGracza) {
        this.znakGracza = znakGracza;
    }

    public Bot(Game game1, Board planszaKiK) {
        this.game1 = game1;
        this.planszaKiK = planszaKiK;
    }

    public void wykonajRuch() {

        if (czyZarazWygrasz()) {

            wykonajZwycieskiRuch();
            return;
        }
        if (czyZarazPrzegrasz()) {

            wykonajBlokujacyRuch();
            return;
        }

        if (planszaKiK.getBoardTable()[planszaKiK.getBoardTable().length / 2][planszaKiK.getBoardTable().length / 2] == planszaKiK.getZnakWolnegoPola()) {

            game1.botMove2(planszaKiK.getBoardTable().length / 2, planszaKiK.getBoardTable().length / 2);
            return;
        }


        wykonajLosowyRuch();

    }

    private void wykonajLosowyRuch() {


        int wiersz;
        int kolumna;
        do {
            wiersz = wylosujLiczbeInt(3);
            kolumna = wylosujLiczbeInt(3);
            if (planszaKiK.sprawdzCzyWolnePole(wiersz, kolumna)) {
                game1.botMove2(wiersz, kolumna);

                return;
            }

        } while (!(planszaKiK.sprawdzCzyWolnePole(wiersz, kolumna)));
    }

    public int wylosujLiczbeInt(int bound) {
        Random random = new Random();
        int liczba = random.nextInt(bound);
        return liczba;

    }

    public boolean czyZarazWygrasz() {
        char znakWolnegoPola = planszaKiK.getZnakWolnegoPola();
        for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakGracza)[wiersz] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakWolnegoPola)[wiersz] == 1) {
                return true;
            }
        }

        for (int kolumna = 0; kolumna < planszaKiK.getBoardTable().length; kolumna++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakGracza)[kolumna] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakWolnegoPola)[kolumna] == 1) {
                return true;
            }
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakGracza) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakWolnegoPola) == 1) {
            return true;
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakGracza) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakWolnegoPola) == 1) {
            return true;
        }
        return false;

    }

    public void wykonajZwycieskiRuch() {
        char znakWolnegoPola = planszaKiK.getZnakWolnegoPola();

        for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakGracza)[wiersz] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakWolnegoPola)[wiersz] == 1) {
                for (int kolumna = 0; kolumna < planszaKiK.getBoardTable()[wiersz].length; kolumna++) {
                    if (planszaKiK.podajZnak(wiersz, kolumna) == znakWolnegoPola) {

                        game1.botMove2(wiersz, kolumna);

                        return;
                    }
                }
            }
        }

        for (int kolumna = 0; kolumna < planszaKiK.getBoardTable().length; kolumna++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakGracza)[kolumna] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakWolnegoPola)[kolumna] == 1) {
                for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
                    if (planszaKiK.podajZnak(wiersz, kolumna) == znakWolnegoPola) {
                        game1.botMove2(wiersz, kolumna);
                        return;
                    }
                }

            }
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakGracza) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakWolnegoPola) == 1) {
            int kolumna = 0;
            for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
                if (planszaKiK.getBoardTable()[wiersz][kolumna] == znakWolnegoPola) {
                    game1.botMove2(wiersz, kolumna);
                }
                kolumna++;
            }
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakGracza) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakWolnegoPola) == 1) {
            int kolumna = 0;
            for (int wiersz = planszaKiK.getBoardTable().length - 1; wiersz >= 0; wiersz--) {
                if (planszaKiK.getBoardTable()[wiersz][kolumna] == znakWolnegoPola) {
                    game1.botMove2(wiersz, kolumna);
                }
                kolumna++;

            }
        }
        return;

    }


    public boolean czyZarazPrzegrasz() {
        char znakWolnegoPola = planszaKiK.getZnakWolnegoPola();
        char znakPrzeciwnika = game1.getPlayerSymbol();

        for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakPrzeciwnika)[wiersz] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakWolnegoPola)[wiersz] == 1) {
                return true;
            }
        }
        for (int kolumna = 0; kolumna < planszaKiK.getBoardTable().length; kolumna++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakPrzeciwnika)[kolumna] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakWolnegoPola)[kolumna] == 1) {
                return true;
            }
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakPrzeciwnika) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakWolnegoPola) == 1) {
            return true;
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakPrzeciwnika) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakWolnegoPola) == 1) {
            return true;
        }
        return false;

    }


    public void wykonajBlokujacyRuch() {
        char znakWolnegoPola = planszaKiK.getZnakWolnegoPola();
        char znakPrzeciwnika = game1.getPlayerSymbol();
        for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakPrzeciwnika)[wiersz] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWWierszach(znakWolnegoPola)[wiersz] == 1) {
                for (int kolumna = 0; kolumna < planszaKiK.getBoardTable()[wiersz].length; kolumna++) {
                    if (planszaKiK.podajZnak(wiersz, kolumna) == znakWolnegoPola) {
                        game1.botMove2(wiersz, kolumna);
                        return;
                    }
                }

            }
        }
        for (int kolumna = 0; kolumna < planszaKiK.getBoardTable().length; kolumna++) {
            if (planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakPrzeciwnika)[kolumna] == 2 && planszaKiK.sprawdzLiczbyDanegoZnakuWKolumnach(znakWolnegoPola)[kolumna] == 1) {
                for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
                    if (planszaKiK.podajZnak(wiersz, kolumna) == znakWolnegoPola) {
                        game1.botMove2(wiersz, kolumna);
                        return;
                    }
                }
            }
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakPrzeciwnika) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWOpadajacejPrzekatnej(znakWolnegoPola) == 1) {
            int kolumna = 0;
            for (int wiersz = 0; wiersz < planszaKiK.getBoardTable().length; wiersz++) {
                if (planszaKiK.getBoardTable()[wiersz][kolumna] == znakWolnegoPola) {
                    game1.botMove2(wiersz, kolumna);
                }
                kolumna++;
            }
        }
        if (planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakPrzeciwnika) == 2 && planszaKiK.sprawdzLiczbeDanegoZnakuWeWznoszacejPrzekatnej(znakWolnegoPola) == 1) {
            int kolumna = 0;
            for (int wiersz = planszaKiK.getBoardTable().length - 1; wiersz >= 0; wiersz--) {
                if (planszaKiK.getBoardTable()[wiersz][kolumna] == znakWolnegoPola) {
                    game1.botMove2(wiersz, kolumna);
                }
                kolumna++;

            }
        }
        return;

    }


}
