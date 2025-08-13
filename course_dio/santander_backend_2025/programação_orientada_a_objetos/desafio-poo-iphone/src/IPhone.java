public class IPhone implements MusicPlayer, Phone, WebBrowser {

    @Override
    public void play() {
        System.out.println("Tocando a música no iPhone.");
    }

    @Override
    public void pause() {
        System.out.println("Música pausada.");
    }

    @Override
    public void selectSong(String song) {
        System.out.println("Música selecionada: " + song);
    }

    @Override
    public void call(String number) {
        System.out.println("Ligando: " + number);
    }

    @Override
    public void answer() {
        System.out.println("Atendendo a ligação...");
    }

    @Override
    public void startVoicemail() {
        System.out.println("Iniciando correio de voz.");
    }

    @Override
    public void showPage(String url) {
        System.out.println("Mostrando página: " + url);
    }

    @Override
    public void newTab() {
        System.out.println("Nova guia do navegador aberta.");
    }

    @Override
    public void refreshPage() {
        System.out.println("Página atualizada.");
    }
}

