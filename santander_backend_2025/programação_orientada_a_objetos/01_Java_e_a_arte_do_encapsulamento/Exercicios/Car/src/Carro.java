public class Carro {

    private boolean ligado;
    private int velocidade;
    private int marcha; // 0 = ponto morto

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    public void ligar() {
        if (ligado) {
            System.out.println("O carro já está ligado.");
            return;
        }
        ligado = true;
        System.out.println("Carro ligado.");
    }

    public void desligar() {
        if (!ligado) {
            System.out.println("O carro já está desligado.");
            return;
        }
        if (marcha != 0 || velocidade != 0) {
            System.out.println("Para desligar o carro, ele deve estar em ponto morto e com velocidade 0km/h.");
            return;
        }
        ligado = false;
        System.out.println("Carro desligado.");
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Não é possível acelerar no ponto morto.");
            return;
        }
        if (velocidade >= 120) {
            System.out.println("Velocidade máxima atingida (120km/h).");
            return;
        }

        int novaVelocidade = velocidade + 1;
        if (!velocidadePermitida(novaVelocidade, marcha)) {
            System.out.println("Troque a marcha para acelerar mais.");
            return;
        }

        velocidade = novaVelocidade;
        System.out.println("Velocidade atual: " + velocidade + "km/h");
    }

    public void desacelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade == 0) {
            System.out.println("O carro já está parado.");
            return;
        }
        velocidade = Math.max(0, velocidade - 1);
        System.out.println("Velocidade atual: " + velocidade + "km/h");
    }

    public void virar(String direcao) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Só é possível virar entre 1km/h e 40km/h.");
            return;
        }
        System.out.println("Virando para a " + direcao + ".");
    }

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + "km/h | Marcha: " + marcha);
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
            return;
        }
        if (Math.abs(novaMarcha - marcha) > 1) {
            System.out.println("Não é permitido pular marchas.");
            return;
        }
        if (!velocidadePermitida(velocidade, novaMarcha)) {
            System.out.println("A velocidade atual não é compatível com a marcha " + novaMarcha + ".");
            return;
        }
        marcha = novaMarcha;
        System.out.println("Marcha trocada para: " + marcha);
    }

    private boolean velocidadePermitida(int vel, int march) {
        return switch (march) {
            case 0 -> vel == 0;
            case 1 -> vel >= 0 && vel <= 20;
            case 2 -> vel >= 21 && vel <= 40;
            case 3 -> vel >= 41 && vel <= 60;
            case 4 -> vel >= 61 && vel <= 80;
            case 5 -> vel >= 81 && vel <= 100;
            case 6 -> vel >= 101 && vel <= 120;
            default -> false;
        };
    }
}
