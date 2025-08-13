public class Main {
    public static void main(String[] args) {
        IPhone iphone = new IPhone();

        iphone.selectSong("Imagine - John Lennon");
        iphone.play();
        iphone.pause();

        iphone.call("+55 51 99999-9999");
        iphone.answer();
        iphone.startVoicemail();

        iphone.showPage("https://www.google.com");
        iphone.newTab();
        iphone.refreshPage();
    }
}
